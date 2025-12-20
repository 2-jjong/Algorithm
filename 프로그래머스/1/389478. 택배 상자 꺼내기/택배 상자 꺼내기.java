class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        // 1. 내가 찾는 상자의 column 위치를 먼저 구한다.
        int targetCol = getCol(num, w);
        
        // 2. num번 상자부터 마지막 n번 상자까지 확인한다.
        // 같은 열에 있다면 내 위에 쌓여있는 상자
        for (int i = num; i <= n; i++) {
            if (getCol(i, w) == targetCol) {
                answer++;
            }
        }
        
        return answer;
    }

    // 어떤 상자 번호가 들어오면 왼쪽에서 몇 번째에 있는지 반환
    private int getCol(int n, int w) {
        int row = (n - 1) / w;    // 몇 번째 층인지 (0부터 시작)
        int pos = (n - 1) % w;    // 그 층에서 몇 번째 칸인지
        
        // 짝수 층이면 왼쪽 -> 오른쪽 순서
        // 홀수 층이면 오른쪽 -> 왼쪽 순서이므로 위치를 뒤집어줌
        if (row % 2 == 1) {
            return (w - 1) - pos;
        }
        return pos;
    }
}