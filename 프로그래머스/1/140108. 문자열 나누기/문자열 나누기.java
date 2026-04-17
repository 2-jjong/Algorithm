class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = s.charAt(0);
        int countX = 0;
        int countOther = 0;

        for (int i = 0; i < s.length(); i++) {
            // 두 카운트가 0이라면 새로운 부분 문자열의 시작
            if (countX == 0 && countOther == 0) {
                x = s.charAt(i);
            }

            // 현재 문자가 x인지 아닌지에 따라 카운트 증가
            if (s.charAt(i) == x) {
                countX++;
            } else {
                countOther++;
            }

            // 두 카운트가 같아지면 문자열 분리
            if (countX == countOther) {
                answer++;
                countX = 0;
                countOther = 0;
            }
        }

        // 반복문이 끝나고 카운트가 남아있다면 마지막 문자열 처리
        if (countX != 0 || countOther != 0) {
            answer++;
        }

        return answer;
    }
}