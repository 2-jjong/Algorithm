import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health; // 최대 체력
        int currentHealth = health; // 현재 체력
        int bandageTime = bandage[0]; // 시전 시간 (t)
        int recoveryPerSec = bandage[1]; // 초당 회복량 (x)
        int bonusRecovery = bandage[2]; // 추가 회복량 (y)
        
        // 공격 정보 맵에 저장
        Map<Integer, Integer> attackMap = new HashMap<>();
        for (int[] attack : attacks) {
            attackMap.put(attack[0], attack[1]);
        }
        
        int lastAttackTime = attacks[attacks.length - 1][0]; // 마지막 공격 시간
        int continuousSuccessTime = 0; // 연속 성공 시간
        
        // 1초부터 마지막 공격 시간까지 반복
        for (int t = 1; t <= lastAttackTime; t++) {
            // 1. 공격을 받았을 때
            if (attackMap.containsKey(t)) {
                currentHealth -= attackMap.get(t);
                continuousSuccessTime = 0;
                
                if (currentHealth <= 0) return -1; // 사망
            } 
            // 2. 공격이 없을 때 (회복)
            else {
                continuousSuccessTime++;
                currentHealth += recoveryPerSec;
                
                // 연속 성공 달성 시 추가 회복
                if (continuousSuccessTime == bandageTime) {
                    currentHealth += bonusRecovery;
                    continuousSuccessTime = 0;
                }
                
                // 최대 체력 초과 금지
                if (currentHealth > maxHealth) currentHealth = maxHealth;
            }
        }
        
        return currentHealth;
    }
}