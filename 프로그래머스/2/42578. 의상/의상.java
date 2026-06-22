import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();
        
        for (String[] c : clothes) {
            String type = c[1];
            
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for (int count : clothesMap.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}