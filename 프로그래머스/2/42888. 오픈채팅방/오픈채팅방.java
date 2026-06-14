import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        
        for (String r : record) {
            String[] parts = r.split(" ");
            String command = parts[0];
            String uid = parts[1];
            
            if (command.equals("Enter") || command.equals("Change")) {
                String nickname = parts[2];
                userMap.put(uid, nickname);
            }
        }
        
        List<String> resultList = new ArrayList<>();
        
        for (String r : record) {
            String[] parts = r.split(" ");
            String command = parts[0];
            String uid = parts[1];
            
            String currentNickname = userMap.get(uid);
            
            if (command.equals("Enter")) {
                resultList.add(currentNickname + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                resultList.add(currentNickname + "님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}