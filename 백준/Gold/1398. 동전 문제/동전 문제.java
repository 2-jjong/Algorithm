import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 0~99원까지 미리 계산
        int[] dp = new int[100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int[] coins = {1, 10, 25};
        for (int coin : coins) {
            for (int i = coin; i < 100; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());
            long count = 0;

            // N이 0이 될 때까지 100 단위씩 끊어서 계산
            while (N > 0) {
                int num = (int) (N % 100);
                count += dp[num];
                N /= 100; // 다음 100 단위로 이동
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb.toString().trim());
    }
}