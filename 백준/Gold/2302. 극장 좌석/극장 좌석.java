import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // DP 미리 계산
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int answer = 1;
        int lastVip = 0; // 이전 VIP 좌석 번호

        // VIP 좌석을 기준으로 구간별 경우의 수 곱하기
        for (int i = 0; i < M; i++) {
            int currentVip = Integer.parseInt(br.readLine());
            
            // 이전 VIP 좌석과 현재 VIP 좌석 사이에 있는 좌석들의 경우의 수를 곱함
            answer *= dp[currentVip - lastVip - 1];
            
            lastVip = currentVip;
        }

        // 마지막 VIP 좌석부터 끝 좌석까지의 구간 처리
        answer *= dp[N - lastVip];

        System.out.println(answer);
    }
}