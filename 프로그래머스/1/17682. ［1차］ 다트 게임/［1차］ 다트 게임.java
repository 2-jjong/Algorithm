import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3]; // 세 번의 기회 점수 저장
        int idx = -1; // 현재 기회 순서 인덱스
        
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            // 1. 숫자일 때
            if (Character.isDigit(c)) {
                idx++;
                if (c == '1' && dartResult.charAt(i + 1) == '0') {
                    score[idx] = 10;
                    i++;
                } else {
                    score[idx] = c - '0';
                }
            } 
            
            // 2. 보너스일 때
            else if (c == 'S') {
                score[idx] = (int) Math.pow(score[idx], 1);
            } else if (c == 'D') {
                score[idx] = (int) Math.pow(score[idx], 2);
            } else if (c == 'T') {
                score[idx] = (int) Math.pow(score[idx], 3);
            } 
            
            // 3. 옵션일 때
            else if (c == '*') {
                score[idx] *= 2;
                
                if (idx > 0) { // 첫 번째가 아니면 직전 점수도 2배
                    score[idx - 1] *= 2;
                }
            } else if (c == '#') {
                score[idx] *= -1;
            }
        }
        
        // 최종 점수 합산
        return score[0] + score[1] + score[2];
    }
}