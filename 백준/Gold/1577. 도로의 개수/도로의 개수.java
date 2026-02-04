import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        boolean[][] horizontal = new boolean[N + 1][M + 1];
        boolean[][] vertical = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 가로 도로 공사
            if (b == d) {
                horizontal[Math.min(a, c)][b] = true;
            } 
            // 세로 도로 공사
            else {
                vertical[a][Math.min(b, d)] = true;
            }
        }

        long[][] dp = new long[N + 1][M + 1];
        dp[0][0] = 1;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                // 왼쪽에서 오는 경우
                if (i > 0 && !horizontal[i - 1][j]) {
                    dp[i][j] += dp[i - 1][j];
                }
                // 위쪽에서 오는 경우
                if (j > 0 && !vertical[i][j - 1]) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}