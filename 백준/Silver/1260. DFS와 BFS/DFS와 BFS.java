import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer>[] graph;
	private static boolean[] visited;
	private static StringBuilder sb;

	public static void dfs(int vertex) {
		visited[vertex] = true;
		sb.append(vertex).append(" ");

		for (int next : graph[vertex]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	public static void bfs(int vertex) {
		Queue<Integer> queue = new LinkedList<>();

		visited[vertex] = true;
		queue.add(vertex);
		sb.append(vertex).append(" ");

		while (!queue.isEmpty()) {
			int currentVertex = queue.poll();

			for (int next : graph[currentVertex]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					sb.append(next).append(" ");
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from].add(to);
			graph[to].add(from);
		}

		for (int i = 0; i < N + 1; i++) {
			Collections.sort(graph[i]);
		}

		dfs(V);
		sb.append("\n");
		Arrays.fill(visited, false);
		bfs(V);

		System.out.println(sb);
	}
}