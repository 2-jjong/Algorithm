import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // dp[인덱스][중간계산값] = 경우의 수
        long[][] dp = new long[N - 1][21];

        // 초기값 설정
        dp[0][numbers[0]] = 1;

        for (int i = 1; i < N - 1; i++) {
            int currentNum = numbers[i];
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) {
                    // 더하기인 경우
                    if (j + currentNum <= 20) {
                        dp[i][j + currentNum] += dp[i - 1][j];
                    }
                    
                    // 빼기인 경우
                    if (j - currentNum >= 0) {
                        dp[i][j - currentNum] += dp[i - 1][j];
                    }
                }
            }
        }

        // 마지막 숫자와 일치하는 경우의 수가 정답
        long answer = dp[N - 2][numbers[N - 1]];
        System.out.println(answer);
    }
}