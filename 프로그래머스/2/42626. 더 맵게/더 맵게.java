import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        while (pq.peek() < K) {
            // 섞을 음식이 부족한 경우
            if (pq.size() < 2) {
                return -1;
            }
            
            // 가장 낮은 두 음식 꺼내기
            int first = pq.poll();
            int second = pq.poll();
            
            // 섞어서 다시 넣기
            int mixed = first + (second * 2);
            pq.add(mixed);
            answer++;
        }
        
        return answer;
    }
}