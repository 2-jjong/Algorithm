import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N + 1];
        
        for (int i = 2; i <= N; i++) {
            // 1을 빼는 경우를 기본값으로 설정
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지면 1을 뺀 경우와 2로 나눈 경우 중 최솟값 선택
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어지면 현재 최솟값과 3으로 나눈 경우 중 최솟값 선택
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}