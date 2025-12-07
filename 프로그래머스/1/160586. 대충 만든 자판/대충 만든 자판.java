import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 각 문자를 입력하는데 필요한 최소 클릭 수
        Map<Character, Integer> minClick = new HashMap<>();
        
        // keymap에서 각 문자의 최소 클릭 수 계산
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int clickCount = i + 1;
                
                // 해당 문자의 최소 클릭 수 업데이트
                minClick.put(c, Math.min(minClick.getOrDefault(c, Integer.MAX_VALUE), clickCount));
            }
        }
        
        // 각 target 문자열에 대해 필요한 총 클릭 수 계산
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalClicks = 0;
            boolean possible = true;
            
            for (char c : target.toCharArray()) {
                if (!minClick.containsKey(c)) {
                    // 해당 문자를 입력할 수 없는 경우
                    possible = false;
                    break;
                }
                totalClicks += minClick.get(c);
            }
            
            answer[i] = possible ? totalClicks : -1;
        }
        
        return answer;
    }
}