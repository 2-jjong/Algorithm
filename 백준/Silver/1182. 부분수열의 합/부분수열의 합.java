import java.util.*;
import java.io.*;

public class Main {
    static int N, S;
    static int[] nums;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    static void dfs(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        dfs(index + 1, sum + nums[index]);
        
        dfs(index + 1, sum);
    }
}