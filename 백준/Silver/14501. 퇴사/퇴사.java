import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1]; // 상담 기간
        int[] P = new int[N + 1]; // 상담 수익
        int[] dp = new int[N + 2]; // i일부터 퇴사일까지의 최대 수익

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 퇴사 전날부터 거꾸로 계산
        for (int i = N; i >= 1; i--) {
            int nextDay = i + T[i];

            if (nextDay <= N + 1) {
                // 상담을 할 수 있는 경우: 오늘 상담 한 경우 vs 안 한 경우
                dp[i] = Math.max(P[i] + dp[nextDay], dp[i + 1]);
            } else {
                // 상담을 할 수 없는 경우: 다음 날의 수익을 그대로 가져옴
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}