import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        Map<String, Integer> discountMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        
        if (isMatch(wantMap, discountMap))
            answer++;

        for (int i = 10; i < discount.length; i++) {
            String outItem = discount[i - 10];
            if (discountMap.get(outItem) == 1) {
                discountMap.remove(outItem);
            } else {
                discountMap.put(outItem, discountMap.get(outItem) - 1);
            }
            
            String inItem = discount[i];
            discountMap.put(inItem, discountMap.getOrDefault(inItem, 0) + 1);
            
            if (isMatch(wantMap, discountMap)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isMatch(Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
        for (String key : wantMap.keySet()) {
            if (discountMap.getOrDefault(key, 0) < wantMap.get(key)) {
                return false;
            }
        }
        
        return true;
    }
}