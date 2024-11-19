import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] grid = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        int max = 0;

        for (int i = 0; i < N - 8 + 1; i++) {
            for (int j = 0; j < M - 8 + 1; j++) {
                int count = checkSubgrid(grid, i, j);
                max = Math.max(max, count);
            }
        }

        System.out.println(64 - max);
    }

    public static int checkSubgrid(char[][] grid, int row, int col) {
        char[][] bwGrid = {{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};

        char[][] wbGrid = {{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};

        int bwCount = 0;
        int wbCount = 0;

        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                if (grid[i][j] == bwGrid[i - row][j - col]) {
                    bwCount++;
                }

                if (grid[i][j] == wbGrid[i - row][j - col]) {
                    wbCount++;
                }
            }
        }

        return Math.max(bwCount, wbCount);
    }
}