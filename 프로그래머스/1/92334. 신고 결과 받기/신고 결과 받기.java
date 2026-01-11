import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 1. 각 유저별로 자신을 신고한 사람들의 이름을 저장
        Map<String, Set<String>> reportHistory = new HashMap<>();
        for (String id : id_list) {
            reportHistory.put(id, new HashSet<>());
        }
        
        for (String r : report) {
            String[] split = r.split(" ");
            String from = split[0]; // 신고한 사람
            String to = split[1];   // 신고당한 사람
            reportHistory.get(to).add(from);
        }
        
        // 2. 메일 수 카운팅
        Map<String, Integer> mailCount = new HashMap<>();
        for (String id : id_list) {
            mailCount.put(id, 0);
        }
        
        for (String id : id_list) {
            Set<String> reporters = reportHistory.get(id);
            if (reporters.size() >= k) { // k번 이상 신고당했다면 정지
                for (String reporter : reporters) {
                    mailCount.put(reporter, mailCount.get(reporter) + 1);
                }
            }
        }
        
        // 3. 결과 배열 변환
        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            answer[i] = mailCount.get(id);
        }
        
        return answer;
    }
}