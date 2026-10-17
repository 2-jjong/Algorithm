class Solution {
    public int solution(int[][] board) {
        int max = 0;
        int n = board.length;
        int m = board[0].length;
        
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 1) max = 1;
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 1) max = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1;
                    max = Math.max(max, board[i][j]);
                }
            }
        }
        
        return max * max;
    }
}