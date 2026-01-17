import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // 결과를 담을 배열 생성
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0]; // 시작 위치
            int end = commands[i][1];   // 끝 위치
            int k = commands[i][2];     // K번째 위치

            // 배열 자르기
            int[] temp = Arrays.copyOfRange(array, start - 1, end);

            // 오름차순 정렬
            Arrays.sort(temp);

            // K번째 수 추출
            answer[i] = temp[k - 1];
        }

        return answer;
    }
}