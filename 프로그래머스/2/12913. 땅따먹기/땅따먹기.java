class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            land[i][0] += max(land[i - 1][1], land[i - 1][2], land[i - 1][3]);
            land[i][1] += max(land[i - 1][0], land[i - 1][2], land[i - 1][3]);
            land[i][2] += max(land[i - 1][0], land[i - 1][1], land[i - 1][3]);
            land[i][3] += max(land[i - 1][0], land[i - 1][1], land[i - 1][2]);
        }

        int lastRow = land.length - 1;
        return max(land[lastRow][0], land[lastRow][1], land[lastRow][2], land[lastRow][3]);
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    
    private int max(int a, int b, int c, int d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }
}