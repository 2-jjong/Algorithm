import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        // 사과 점수를 오름차순으로 정렬
        Arrays.sort(score);
        
        // 큰 점수부터 m개씩 묶어서 계산
        for (int i = score.length - m; i >= 0; i -= m) {
            answer += score[i] * m;
        }
        
        return answer;
    }
}