import java.util.*;

class Solution {
    static class Task {
        String name;
        int start;
        int playTime;

        public Task(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }

    public String[] solution(String[][] plans) {
        List<Task> tasks = new ArrayList<>();
        for (String[] plan : plans) {
            String name = plan[0];
            int start = toMinute(plan[1]);
            int playTime = Integer.parseInt(plan[2]);
            tasks.add(new Task(name, start, playTime));
        }

        tasks.sort(Comparator.comparingInt(t -> t.start));

        List<String> finishedTasks = new ArrayList<>();
        Stack<Task> pausedTasks = new Stack<>();

        for (int i = 0; i < tasks.size(); i++) {
            Task current = tasks.get(i);

            if (i == tasks.size() - 1) {
                finishedTasks.add(current.name);
                break;
            }

            Task next = tasks.get(i + 1);
            int availableTime = next.start - current.start;

            if (current.playTime <= availableTime) {
                finishedTasks.add(current.name);
                int remainingTime = availableTime - current.playTime;

                while (!pausedTasks.isEmpty() && remainingTime > 0) {
                    Task paused = pausedTasks.peek();

                    if (paused.playTime <= remainingTime) {
                        remainingTime -= paused.playTime;
                        finishedTasks.add(pausedTasks.pop().name);
                    } else {
                        paused.playTime -= remainingTime;
                        remainingTime = 0;
                    }
                }
            } else {
                current.playTime -= availableTime;
                pausedTasks.push(current);
            }
        }

        while (!pausedTasks.isEmpty()) {
            finishedTasks.add(pausedTasks.pop().name);
        }

        return finishedTasks.toArray(new String[0]);
    }

    private int toMinute(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}