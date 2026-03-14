import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] S;
    static boolean[] check = new boolean[2000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        int answer = 1;
        while (check[answer]) {
            answer++;
        }

        System.out.println(answer);
    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum > 0)
                check[sum] = true;
            return;
        }

        // 현재 원소를 포함하는 경우
        dfs(idx + 1, sum + S[idx]);
        // 현재 원소를 포함하지 않는 경우
        dfs(idx + 1, sum);
    }
}