class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        
        // 1. 4방향 이동을 위한 배열 설정
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        // 2. 4방향을 하나씩 확인
        for (int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];
            
            // 3. 격자 범위를 벗어나지 않는지 확인
            if (nh >= 0 && nh < n && nw >= 0 && nw < n) {
                // 4. 색깔이 일치하면 카운팅
                if (board[h][w].equals(board[nh][nw])) {
                    count++;
                }
            }
        }
        
        return count;
    }
}