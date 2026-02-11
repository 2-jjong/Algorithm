import java.util.*;
import java.io.*;

public class Main {
    static int[][] board = new int[20][20];
    // 가로, 세로, 우하 대각선, 우상 대각선
    static int[] dr = {0, 1, 1, -1};
    static int[] dc = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 왼쪽 돌을 찾기 위해 열부터 순회
        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                if (board[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        if (check(i, j, k)) {
                            System.out.println(board[i][j]);
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
                }
            }
        }
        
        System.out.println(0);
    }

    static boolean check(int r, int c, int d) {
        int color = board[r][c];
        
        // 육목 체크
        int prevR = r - dr[d];
        int prevC = c - dc[d];
        if (isRange(prevR, prevC) && board[prevR][prevC] == color) {
            return false;
        }

        // 5개의 돌이 연속되는지 확인
        int cnt = 1;
        int nextR = r + dr[d];
        int nextC = c + dc[d];
        while (isRange(nextR, nextC) && board[nextR][nextC] == color) {
            cnt++;
            nextR += dr[d];
            nextC += dc[d];
        }

        return cnt == 5;
    }

    static boolean isRange(int r, int c) {
        return r >= 1 && r <= 19 && c >= 1 && c <= 19;
    }
}