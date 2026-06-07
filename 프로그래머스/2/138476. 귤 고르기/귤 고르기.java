import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> sizeMap = new HashMap<>();

        for (int size : tangerine) {
            sizeMap.put(size, sizeMap.getOrDefault(size, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(sizeMap.values());

        counts.sort(Collections.reverseOrder());

        for (int count : counts) {
            k -= count;
            answer++;
            
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}