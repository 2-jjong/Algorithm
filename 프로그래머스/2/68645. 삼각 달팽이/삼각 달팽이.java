class Solution {
    public int[] solution(int n) {
        int max = n * (n + 1) / 2;
        int[] answer = new int[max];
        
        int[][] matrix = new int[n][n];
        
        int r = -1;
        int c = 0;
        int num = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    r++;
                } else if (i % 3 == 1) {
                    c++;
                } else {
                    r--;
                    c--;
                }
                
                matrix[r][c] = num++;
            }
        }
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = matrix[i][j];
            }
        }
        
        return answer;
    }
}