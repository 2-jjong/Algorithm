import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	private static class Vertex implements Comparable<Vertex> {
		public int no;
		public Vertex link;
		public long weight;

		public Vertex(int vertex, Vertex next, long weight) {
			this.no = vertex;
			this.link = next;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	private static Vertex[] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			/**
			 * 1. 입력 파일 객체화
			 */

			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			graph = new Vertex[V + 1];
			visited = new boolean[V + 1];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				long C = Long.parseLong(st.nextToken());

				graph[A] = new Vertex(B, graph[A], C);
				graph[B] = new Vertex(A, graph[B], C);
			}

			/**
			 * 2. 알고리즘 풀기
			 */

			long result = prim(V);

			/**
			 * 3. 정답 출력
			 */

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	static long prim(int V) {
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(1, null, 0));
		long totalWeight = 0;
		int count = 0;

		while (!pq.isEmpty()) {
			Vertex current = pq.poll();

			if (visited[current.no])
				continue;

			visited[current.no] = true;
			totalWeight += current.weight;
			count++;

			if (count == V)
				break;

			for (Vertex next = graph[current.no]; next != null; next = next.link) {
				if (!visited[next.no]) {
					pq.add(new Vertex(next.no, null, next.weight));
				}
			}
		}

		return totalWeight;
	}
}