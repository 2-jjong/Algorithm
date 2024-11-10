import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] graph;
	static boolean[] visited;
	static List<Integer> answer;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		answer = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start].add(end);
		}

		bfs(x, k);

		if (answer.size() == 0) {
			System.out.println(-1);
			return;
		}

		Collections.sort(answer);

		for (int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i)).append("\n");
		}

		System.out.println(sb);

	}

	public static void bfs(int start, int k) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { start, 0 });
		visited[start] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int node = current[0];
			int depth = current[1];

			if (depth > k)
				break;

			if (depth == k)
				answer.add(node);

			for (int neighbor : graph[node]) {
				if (!visited[neighbor]) {
					queue.add(new int[] { neighbor, depth + 1 });
					visited[neighbor] = true;
				}
			}
		}
	}

}