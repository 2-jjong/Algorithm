import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> brotherSet = new HashSet<>();
        
        Map<Integer, Integer> chulsooMap = new HashMap<>();
        for (int t : topping) {
            chulsooMap.put(t, chulsooMap.getOrDefault(t, 0) + 1);
        }
        
        for (int t : topping) {
            brotherSet.add(t);
            
            chulsooMap.put(t, chulsooMap.get(t) - 1);
            
            if (chulsooMap.get(t) == 0) {
                chulsooMap.remove(t);
            }
            
            if (brotherSet.size() == chulsooMap.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}