import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // i개의 돌이 있을 때 상근이가 이기면 true, 지면 false
        boolean[] dp = new boolean[Math.max(4, N + 1)];

        // 초기값
        dp[1] = true;  // SK 승
        dp[2] = false; // CY 승
        dp[3] = true;  // SK 승

        for (int i = 4; i <= N; i++) {
            if (!dp[i - 1] || !dp[i - 3]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        if (dp[N]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}