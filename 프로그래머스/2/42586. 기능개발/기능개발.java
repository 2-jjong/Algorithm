import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> daysQueue = new LinkedList<>();

        // 1. 각 작업의 남은 일수 계산
        for (int i = 0; i < progresses.length; i++) {
            int workload = 100 - progresses[i];
            int days = workload / speeds[i];
            
            if (workload % speeds[i] != 0)
                days++;
            
            daysQueue.add(days);
        }

        // 2. 배포될 기능 개수 계산
        while (!daysQueue.isEmpty()) {
            int currentDay = daysQueue.poll();
            int count = 1;

            // 다음 기능들이 currentDay보다 빨리 끝나면 함께 배포
            while (!daysQueue.isEmpty() && daysQueue.peek() <= currentDay) {
                daysQueue.poll();
                count++;
            }

            answerList.add(count);
        }

        // 3. 리스트를 배열로 변환
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}