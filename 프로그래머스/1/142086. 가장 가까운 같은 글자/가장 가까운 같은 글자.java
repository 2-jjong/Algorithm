import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        // 글자별 마지막 위치를 저장할 맵 (알파벳 : 인덱스)
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // 1. 이 글자가 이전에 나온 적이 있는지 확인
            if (!map.containsKey(ch)) {
                // 처음 나왔다면 -1
                answer[i] = -1;
            } else {
                // 이전에 나왔다면 현재 위치(i) - 마지막 위치
                answer[i] = i - map.get(ch);
            }
            
            // 2. 현재 글자의 위치를 최신 정보로 갱신
            map.put(ch, i);
        }
        
        return answer;
    }
}