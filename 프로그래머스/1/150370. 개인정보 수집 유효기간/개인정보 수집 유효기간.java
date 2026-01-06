import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        
        // 1. 오늘 날짜를 일 단위로 변환
        int todayTotalDays = convertToDays(today);
        
        // 2. 약관 정보도 일 단위로 변환하여 맵에 저장
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]) * 28);
        }
        
        // 3. 개인정보 하나씩 유효기간이 지났는지 비교
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            int currentDays = convertToDays(split[0]);
            int termDays = termMap.get(split[1]);
            
            // 수집일 + 유효기간 <= 오늘이면 파기
            if (currentDays + termDays <= todayTotalDays) {
                answerList.add(i + 1); 
            }
        }
        
        // 4. 결과 리스트를 배열로 변환
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    // YYYY.MM.DD 형식을 일 단위로 변환
    private int convertToDays(String date) {
        String[] split = date.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}