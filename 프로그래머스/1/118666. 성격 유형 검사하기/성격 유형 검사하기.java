import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scores = new HashMap<>();
        
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (char type : types) {
            scores.put(type, 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int choice = choices[i];
            
            if (choice < 4) {
                scores.put(first, scores.get(first) + (4 - choice));
            } else if (choice > 4) {
                scores.put(second, scores.get(second) + (choice - 4));
            }
        }
        
        StringBuilder answer = new StringBuilder();
        
        answer.append(scores.get('R') >= scores.get('T') ? 'R' : 'T');
        answer.append(scores.get('C') >= scores.get('F') ? 'C' : 'F');
        answer.append(scores.get('J') >= scores.get('M') ? 'J' : 'M');
        answer.append(scores.get('A') >= scores.get('N') ? 'A' : 'N');
        
        return answer.toString();
    }
}