class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow; // 전체 격자 개수
        
        // 세로(h)는 3부터 시작해서 전체 개수의 제곱근까지만 확인
        for (int h = 3; h <= Math.sqrt(total); h++) {
            if (total % h == 0) {
                int w = total / h; // 가로(w) 구하기
                
                // 노란색 격자 수 조건 확인
                if ((w - 2) * (h - 2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        return answer;
    }
}