import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long totalWork = 0;
        for (int w : works) {
            totalWork += w;
        }

        if (totalWork <= n) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) {
            pq.offer(w);
        }

        while (n > 0) {
            int max = pq.poll();
            pq.offer(max - 1);
            n--;
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}