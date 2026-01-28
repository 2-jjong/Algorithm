import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 애니메이션 개수
        int M = Integer.parseInt(st.nextToken()); // 사용할 수 있는 시간
        int K = Integer.parseInt(st.nextToken()); // 동시에 볼 수 있는 개수

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(arr, 1, N + 1);

        // DP 수행
        long[] dp = new long[N + 1];
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (i <= K) {
                // K개까지는 한꺼번에 볼 수 있으므로 가장 긴 애니메이션 시간이 dp[i] 까지의 시간
                dp[i] = arr[i];
            } else {
                // K개를 넘어가게 된다면 가장 긴 것부터 K개만큼 묶어서 계산
                // i-K번째를 다 본 시간 + 현재 묶음의 최대 시간(arr[i])
                dp[i] = dp[i - K] + arr[i];
            }

            // M 시간 내에 볼 수 있는 최대 개수 카운트
            if (dp[i] <= M) {
                count = i;
            } else {
                // 시간을 초과하면 종료
                break;
            }
        }

        System.out.println(count);
    }
}