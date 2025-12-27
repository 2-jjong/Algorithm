import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // 각 시간대에 수명이 다해서 반납될 서버의 개수를 기록
        int[] serverExpiration = new int[24];
        
        int currentRunningServers = 0; // 현재 가동 중인 추가 서버 대수

        for (int hour = 0; hour < 24; hour++) {
            // 현재 시간에 수명이 다한 서버들을 가동 대수에서 제외
            currentRunningServers -= serverExpiration[hour];

            // 현재 시간의 이용자 수에 필요한 총 서버 대수 계산
            int requiredServers = players[hour] / m;

            // 현재 가동 중인 서버가 부족하다면 증설
            if (currentRunningServers < requiredServers) {
                int expansionCount = requiredServers - currentRunningServers;
                
                answer += expansionCount; // 총 증설 횟수 누적
                currentRunningServers += expansionCount; // 현재 가동 서버에 추가
                
                // k시간 뒤에 서버 반납
                if (hour + k < 24) {
                    serverExpiration[hour + k] += expansionCount;
                }
            }
        }

        return answer;
    }
}