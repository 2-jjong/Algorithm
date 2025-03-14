import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] islands;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static PriorityQueue<Edge> edges = new PriorityQueue<>();

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int length;

		public Edge(int from, int to, int length) {
			this.from = from;
			this.to = to;
			this.length = length;
		}

		@Override
		public int compareTo(Edge o) {
			return this.length - o.length;
		}
	}

	static void bfs(int x, int y, int islandNum) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;
		islands[x][y] = islandNum;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (map[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						islands[nx][ny] = islandNum;
						queue.add(new int[] { nx, ny });
					}
				}
			}
		}
	}

	static void findBridges(int x, int y) {
		int currentIsland = islands[x][y];

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			int length = 0;

			while (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (islands[nx][ny] == currentIsland)
					break;

				if (islands[nx][ny] != 0) {
					if (length >= 2) {
						edges.add(new Edge(currentIsland, islands[nx][ny], length));
					}
					break;
				}

				length++;
				nx += dx[d];
				ny += dy[d];
			}
		}
	}

	static int kruskal(int totalIslands) {
		int[] parent = new int[totalIslands + 1];

		for (int i = 1; i <= totalIslands; i++)
			parent[i] = i;

		int sum = 0;
		int edgeCount = 0;
		while (!edges.isEmpty()) {
			Edge edge = edges.poll();

			int from = find(parent, edge.from);
			int to = find(parent, edge.to);

			if (union(parent, from, to)) {
				sum += edge.length;

				if (++edgeCount == N - 1)
					break;
			}
		}

		return (edgeCount == totalIslands - 1) ? sum : -1;
	}

	static int find(int[] parent, int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent, parent[x]);
	}

	static boolean union(int[] parent, int a, int b) {
		int aRoot = find(parent, a);
		int bRoot = find(parent, b);

		if (aRoot == bRoot)
			return false;

		parent[bRoot] = aRoot;

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		islands = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 인덱싱
		int islandCount = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j, islandCount++);
				}
			}
		}

		// 다리 후보 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (islands[i][j] != 0) {
					findBridges(i, j);
				}
			}
		}

		// MST 계산
		int result = kruskal(islandCount - 1);
		System.out.println(result);
	}
}