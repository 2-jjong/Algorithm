import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int e = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[n + 1];

        dfs(1, graph, visited);

        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (visited[i]) sum++;
        }

        System.out.println(sum);
    }

    public static void dfs(int node, List<Integer>[] graph, boolean[] visited) {
        if (visited[node]) return;

        visited[node] = true;

        for (int neighbor : graph[node]) {
            dfs(neighbor, graph, visited);
        }
    }
}