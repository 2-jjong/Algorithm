import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for (int num : queue1) {
            q1.add(num);
            sum1 += num;
        }
        for (int num : queue2) {
            q2.add(num);
            sum2 += num;
        }
        
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }
        
        int limit = queue1.length * 4; 
        
        for (int i = 0; i <= limit; i++) {
            if (sum1 == sum2) {
                return i;
            }
            
            if (sum1 > sum2) {
                int val = q1.poll();
                q2.add(val);
                sum1 -= val;
                sum2 += val;
            } else {
                int val = q2.poll();
                q1.add(val);
                sum1 += val;
                sum2 -= val;
            }
        }
        
        return -1;
    }
}