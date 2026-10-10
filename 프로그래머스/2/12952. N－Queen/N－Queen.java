class Solution {
    private int answer = 0;
    private boolean[] usedCol;
    private boolean[] usedDiag1;
    private boolean[] usedDiag2;

    public int solution(int n) {
        usedCol = new boolean[n];
        usedDiag1 = new boolean[2 * n];
        usedDiag2 = new boolean[2 * n];

        backtrack(0, n);

        return answer;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;

            if (usedCol[col] || usedDiag1[d1] || usedDiag2[d2]) {
                continue;
            }

            usedCol[col] = true;
            usedDiag1[d1] = true;
            usedDiag2[d2] = true;

            backtrack(row + 1, n);

            usedCol[col] = false;
            usedDiag1[d1] = false;
            usedDiag2[d2] = false;
        }
    }
}