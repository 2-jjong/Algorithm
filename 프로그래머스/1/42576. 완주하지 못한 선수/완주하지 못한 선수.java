import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        // 1. 참여자 명단 맵에 카운팅
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 2. 완주자 명단 기준으로 카운트 차감
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // 3. value가 0이 아닌 사람(미완주자) 탐색
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
            }
        }
        
        return answer;
    }
}