import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static List<Integer>[] graph;
	private static boolean[] visited;

	public static int bfs(int vertex, int depth) {
		Queue<int[]> queue = new LinkedList<>();
		int answerVertex = vertex;
		int maxDepth = depth;

		visited[vertex] = true;
		queue.add(new int[] { vertex, depth });

		while (!queue.isEmpty()) {
			int[] currentNode = queue.poll();
			int currentVertex = currentNode[0];
			int currentDepth = currentNode[1];

			if (currentDepth > maxDepth) {
				maxDepth = currentDepth;
				answerVertex = currentVertex;
			} else if (currentDepth == maxDepth) {
				answerVertex = Math.max(answerVertex, currentVertex);
			}

			for (int next : graph[currentVertex]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(new int[] { next, currentDepth + 1 });
				}
			}
		}

		return answerVertex;
	}

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			/**
			 * 1. 입력 파일 객체화
			 */

			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			graph = new ArrayList[101];
			visited = new boolean[101];

			for (int i = 1; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph[from].add(to);
			}

			/**
			 * 2. 알고리즘 풀기
			 */

			int answer = bfs(start, 0);

			/**
			 * 3. 정답 출력
			 */

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}