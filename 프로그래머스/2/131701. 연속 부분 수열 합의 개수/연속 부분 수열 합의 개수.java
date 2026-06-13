import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();
        int n = elements.length;

        for (int start = 0; start < n; start++) {
            int currentSum = 0;
            
            for (int len = 0; len < n; len++) {
                int index = (start + len) % n;
                currentSum += elements[index];
                
                sumSet.add(currentSum);
            }
        }

        return sumSet.size();
    }
}