import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = Arrays.stream(picks).sum();
        
        // 실제로 캘 수 있는 광물의 범위만 잘라냄
        int limit = Math.min(minerals.length, totalPicks * 5);
        
        // 5개씩 묶어서 광물 정보 저장
        List<int[]> groups = new ArrayList<>();
        for (int i = 0; i < limit; i += 5) {
            int[] counts = new int[3]; // 0:다이아, 1:철, 2:돌
            for (int j = i; j < Math.min(i + 5, limit); j++) {
                if (minerals[j].equals("diamond")) counts[0]++;
                else if (minerals[j].equals("iron")) counts[1]++;
                else counts[2]++;
            }
            groups.add(counts);
        }

        // 피로도가 높은 순서대로 정렬
        Collections.sort(groups, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            if (a[1] != b[1]) return b[1] - a[1];
            return b[2] - a[2];
        });

        // 정렬된 그룹에 좋은 곡괭이부터 순서대로 사용
        int pickIdx = 0; // 0:다이아, 1:철, 2:돌 곡괭이 순서
        for (int[] group : groups) {
            // 현재 쓸 수 있는 곡괭이 찾기
            while (pickIdx < 3 && picks[pickIdx] == 0) {
                pickIdx++;
            }
            
            // 곡괭이를 다 썼을 때
            if (pickIdx == 3)
                break;

            // 피로도 계산
            answer += calculateFatigue(pickIdx, group);
            picks[pickIdx]--;
        }

        return answer;
    }

    private int calculateFatigue(int pickType, int[] group) {
        int fatigue = 0;
        int dia = group[0];
        int iron = group[1];
        int stone = group[2];

        if (pickType == 0) { // 다이아 곡괭이
            fatigue = dia + iron + stone;
        } else if (pickType == 1) { // 철 곡괭이
            fatigue = (dia * 5) + iron + stone;
        } else { // 돌 곡괭이
            fatigue = (dia * 25) + (iron * 5) + stone;
        }
        
        return fatigue;
    }
}