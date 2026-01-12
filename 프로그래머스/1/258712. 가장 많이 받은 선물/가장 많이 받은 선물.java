import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 1. 이름으로 배열 인덱스를 즉시 찾기 위한 맵 생성
        int n = friends.length;
        Map<String, Integer> friendsIdxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            friendsIdxMap.put(friends[i], i);
        }

        int[] giftScore = new int[n]; // 개인별 선물 지수
        int[][] giftHistory = new int[n][n]; // 선물 주고받은 이력

        // 2. 선물 지수와 이력 저장
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            int giver = friendsIdxMap.get(split[0]);
            int receiver = friendsIdxMap.get(split[1]);

            giftHistory[giver][receiver]++;
            giftScore[giver]++; // 준 사람은 지수 상승
            giftScore[receiver]--; // 받은 사람은 지수 하락
        }

        // 3. 다음 달에 받을 선물 예측
        int maxGifts = 0;
        for (int i = 0; i < n; i++) {
            int nextMonthGiftCount = 0; // i번째 사람이 다음 달에 받을 선물 합계
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // 자기 자신은 제외

                // 내가 상대방에게 더 많이 줬을 때
                if (giftHistory[i][j] > giftHistory[j][i]) {
                    nextMonthGiftCount++;
                } 
                // 기록이 없거나 횟수가 같을 때 선물 지수 비교
                else if (giftHistory[i][j] == giftHistory[j][i]) {
                    if (giftScore[i] > giftScore[j]) {
                        nextMonthGiftCount++;
                    }
                }
            }
            
            maxGifts = Math.max(maxGifts, nextMonthGiftCount);
        }

        return maxGifts;
    }
}