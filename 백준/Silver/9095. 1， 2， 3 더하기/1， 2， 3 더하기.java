import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        initializeDP(dp);

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append('\n');
        }
        System.out.println(sb);
    }

    private static void initializeDP(int[] dp) {
        dp[1] = 1;
        dp[2] = dp[1] + 1;
        dp[3] = dp[2] + dp[1] + 1;

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
    }
}