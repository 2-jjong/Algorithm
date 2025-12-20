import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 1. 선수의 이름과 현재 등수를 저장할 맵 생성
        Map<String, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        // 2. 경주 진행
        for (String calledName : callings) {
            // 호명된 선수의 현재 등수
            int currentRank = rankMap.get(calledName);
            
            // 바로 앞 선수의 등수와 이름
            int prevRank = currentRank - 1;
            String prevPlayer = players[prevRank];

            // 3. 배열에서 두 선수의 위치 교체 (Swap)
            players[prevRank] = calledName;
            players[currentRank] = prevPlayer;

            // 4. 맵에서 두 선수의 등수 정보 갱신
            rankMap.put(calledName, prevRank);
            rankMap.put(prevPlayer, currentRank);
        }

        return players;
    }
}