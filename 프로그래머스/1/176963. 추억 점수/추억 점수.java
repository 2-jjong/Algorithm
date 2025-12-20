import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 1. 이름별 점수를 빠르게 찾기 위해 HashMap에 저장
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }

        // 2. 각 사진별 점수를 담을 결과 배열
        int[] answer = new int[photo.length];

        // 3. 사진을 하나씩 확인
        for (int i = 0; i < photo.length; i++) {
            int totalScore = 0;
            
            // 한 장의 사진 속에 있는 사람들을 확인
            for (String person : photo[i]) {
                // 맵에 이름이 있으면 점수를 더하고, 없으면 0점을 더함
                totalScore += scoreMap.getOrDefault(person, 0);
            }
            
            answer[i] = totalScore;
        }

        return answer;
    }
}