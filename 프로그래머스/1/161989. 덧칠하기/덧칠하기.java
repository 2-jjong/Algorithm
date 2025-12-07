class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        // 룰러로 칠한 페인트 영역
        int rulerPoint = section[0];

        for(int i=0; i<section.length; i++){
            if(rulerPoint <= section[i]){
                // 페인트칠
                answer++;

                rulerPoint = section[i] + m;
            }
        }

        return answer;
    }
}