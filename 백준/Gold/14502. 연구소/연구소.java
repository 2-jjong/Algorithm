import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] map;
	private static int[][] virusMap;
	private static int safeMax;

	public static void bfs(int[] start, boolean[][] visited) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<int[]> q = new LinkedList<>();

		q.add(start);
		visited[start[0]][start[1]] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nr = cur[0] + dr[dir];
				int nc = cur[1] + dc[dir];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (!visited[nr][nc] && virusMap[nr][nc] != 1) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = true;
					virusMap[nr][nc] = 2;
				}
			}
		}
	}

	public static void virus() {
		boolean[][] visited = new boolean[N][M];
		virusMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, virusMap[i], 0, M);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusMap[i][j] == 2 && !visited[i][j])
					bfs(new int[] { i, j }, visited);
			}
		}
	}

	public static int safe() {
		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusMap[i][j] == 0)
					sum++;
			}
		}

		return sum;
	}

	public static void solve(int cnt) {
		if (cnt == 3) {
			virus();
			safeMax = Math.max(safeMax, safe());

			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					solve(cnt + 1);
					map[i][j] = 0;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		safeMax = 0;
		solve(0);

		System.out.println(safeMax);
	}
}
