import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        result = new int[N];
        visited = new boolean[N + 1];

        dfs(0);
        
        System.out.print(sb.toString().trim());
    }

    static void dfs(int depth) {
        if (depth == N) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}