class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        while (true) {
            boolean[][] check = new boolean[m][n];
            boolean isDeleted = false;
            
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];
                    if (c != '-' && c == map[i][j + 1] && c == map[i + 1][j] && c == map[i + 1][j + 1]) {
                        check[i][j] = true;
                        check[i][j + 1] = true;
                        check[i + 1][j] = true;
                        check[i + 1][j + 1] = true;
                        isDeleted = true;
                    }
                }
            }
            
            if (!isDeleted) {
                break;
            }
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        answer++;
                        map[i][j] = '-';
                    }
                }
            }
            
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == '-') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (map[k][j] != '-') {
                                map[i][j] = map[k][j];
                                map[k][j] = '-';
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}