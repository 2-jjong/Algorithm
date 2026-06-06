import java.util.*;

class Solution {
    static class Process {
        int id;
        int priority;
        
        public Process(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }

        int turn = 0;

        while (!queue.isEmpty()) {
            Process current = queue.poll();
            boolean hasHigherPriority = false;

            for (Process p : queue) {
                if (p.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                queue.add(current);
            } else {
                turn++;
                
                if (current.id == location) {
                    return turn;
                }
            }
        }

        return turn;
    }
}