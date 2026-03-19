import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] health = new int[N];
        int[] joy = new int[N];

        // 체력 소모량
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        // 기쁨 획득량
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            health[i] = Integer.parseInt(st1.nextToken());
            joy[i] = Integer.parseInt(st2.nextToken());
        }

        int[] dp = new int[100];

        for (int i = 0; i < N; i++) {
            int l = health[i];
            int j = joy[i];

            for (int h = 99; h >= l; h--) {
                dp[h] = Math.max(dp[h], dp[h - l] + j);
            }
        }

        System.out.println(dp[99]);
    }
}