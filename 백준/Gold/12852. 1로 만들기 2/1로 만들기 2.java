import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1]; // 최소 연산 횟수 저장
        int[] before = new int[N + 1]; // 경로 역추적을 위한 이전 숫자 저장

        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            before[i] = i - 1;

            // 2로 나누어 떨어지고 횟수가 더 적은 경우
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                before[i] = i / 2;
            }

            // 3으로 나누어 떨어지고 횟수가 더 적은 경우
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                before[i] = i / 3;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[N]).append("\n");

        int curr = N;
        while (curr != 0) {
            sb.append(curr).append(" ");
            curr = before[curr];
        }

        System.out.println(sb.toString().trim());
    }
}