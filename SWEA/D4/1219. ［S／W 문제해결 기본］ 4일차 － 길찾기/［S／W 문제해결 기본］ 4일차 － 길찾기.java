import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int e = Integer.parseInt(st.nextToken());
			List<Integer>[] graph = new ArrayList[100];
			boolean[] visited = new boolean[100];
			for (int i = 0; i < 100; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				graph[start].add(end);
			}

			bfs(graph, visited, 0);

			int answer = visited[99] ? 1 : 0;

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

	public static void bfs(List<Integer>[] graph, boolean[] visited, int start) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int next : graph[node]) {
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}

	}

}