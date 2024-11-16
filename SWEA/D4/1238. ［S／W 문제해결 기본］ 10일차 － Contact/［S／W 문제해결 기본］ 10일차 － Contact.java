import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			List<Integer>[] graph = new ArrayList[101];
			boolean[] visited = new boolean[101];
			int[] distances = new int[101];
			Arrays.fill(distances, 0);

			for (int i = 1; i <= 100; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph[from].add(to);
			}

			bfs(graph, visited, distances, start);

			int maxIndex = 0;

			for (int i = 1; i <= 100; i++) {
				if (distances[i] >= distances[maxIndex]) {
					maxIndex = i;
				}
			}

			sb.append("#").append(testCase).append(" ").append(maxIndex).append("\n");

		}

		System.out.println(sb);

	}

	public static void bfs(List<Integer>[] graph, boolean[] visited, int[] distances, int start) {
		Queue<Integer> queue = new LinkedList<>();

		distances[start] = 1;
		queue.add(start);

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int next : graph[node]) {
				if (!visited[next]) {
					queue.add(next);
					distances[next] = distances[node] + 1;
					visited[next] = true;
				}
			}
		}
	}

}