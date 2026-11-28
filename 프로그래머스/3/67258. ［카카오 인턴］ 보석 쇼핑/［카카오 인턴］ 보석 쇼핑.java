import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int totalTypes = new HashSet<>(Arrays.asList(gems)).size();

        Map<String, Integer> windowMap = new HashMap<>();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        for (int right = 0; right < gems.length; right++) {
            windowMap.put(gems[right], windowMap.getOrDefault(gems[right], 0) + 1);

            while (windowMap.size() == totalTypes) {
                if (right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }

                String leftGem = gems[left];
                int count = windowMap.get(leftGem);
                if (count == 1) {
                    windowMap.remove(leftGem);
                } else {
                    windowMap.put(leftGem, count - 1);
                }
                left++;
            }
        }

        return answer;
    }
}