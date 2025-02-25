import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer>[] graph;
	private static boolean[] visited;
	private static boolean result;

	public static void dfs(int vertex, int depth) {
		visited[vertex] = true;

		if (depth == 5) {
			result = true;
			return;
		}

		for (int next : graph[vertex]) {
			if (!visited[next]) {
				dfs(next, depth + 1);
			}
		}
		
		visited[vertex] = false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int friend1 = Integer.parseInt(st.nextToken());
			int friend2 = Integer.parseInt(st.nextToken());

			graph[friend1].add(friend2);
			graph[friend2].add(friend1);
		}

		for (int i = 0; i < N; i++) {
			dfs(i, 1);
		}

		System.out.println(result ? 1 : 0);
	}
}