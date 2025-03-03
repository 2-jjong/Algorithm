import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int x, y, cost;

		Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}

	private static int N;
	private static int[][] graph;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	static int dijkstra() {
		int[][] distance = new int[N][N];

		for (int[] row : distance) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		distance[0][0] = graph[0][0];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, graph[0][0]));

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int x = current.x;
			int y = current.y;
			int cost = current.cost;

			if (x == N - 1 && y == N - 1)
				return cost;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					int newCost = cost + graph[nx][ny];
					if (newCost < distance[nx][ny]) {
						distance[nx][ny] = newCost;
						pq.offer(new Node(nx, ny, newCost));
					}
				}
			}
		}

		return distance[N - 1][N - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int problemCount = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;

			graph = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = dijkstra();

			sb.append("Problem ").append(problemCount++).append(": ").append(result).append("\n");
		}

		System.out.print(sb);
	}
}