import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int K, W, H;
	private static int[][] map;
	private static int[][][] visited;
	private static int result;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int[] horseR = { -1, -2, -2, -1, 1, 2, 2, 1 };
	private static int[] horseC = { -2, -1, 1, 2, -2, -1, 1, 2 };

	static class Point {
		int r;
		int c;
		int count;
		int k;

		public Point(int r, int c, int count, int k) {
			this.r = r;
			this.c = c;
			this.count = count;
			this.k = k;
		}
	}

	public static void bfs() {
		Queue<Point> q = new LinkedList<>();

		q.add(new Point(0, 0, 0, K));

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (cur.r == H - 1 && cur.c == W - 1) {
				result = cur.count;
				return;
			}

			if (cur.k > 0) {
				for (int dir = 0; dir < 8; dir++) {
					int nr = cur.r + horseR[dir];
					int nc = cur.c + horseC[dir];
					int nCount = cur.count + 1;
					int nk = cur.k - 1;

					if (nr < 0 || nc < 0 || nr >= H || nc >= W)
						continue;

					if (map[nr][nc] == 1)
						continue;

					if (nCount < visited[nr][nc][nk]) {
						q.add(new Point(nr, nc, nCount, nk));
						visited[nr][nc][nk] = nCount;
					}
				}
			}

			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];
				int nCount = cur.count + 1;
				int nk = cur.k;

				if (nr < 0 || nc < 0 || nr >= H || nc >= W)
					continue;

				if (map[nr][nc] == 1)
					continue;

				if (nCount < visited[nr][nc][nk]) {
					q.add(new Point(nr, nc, nCount, nk));
					visited[nr][nc][nk] = nCount;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new int[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				for (int k = 0; k <= K; k++) {
					if (i == 0 && j == 0)
						visited[i][j][k] = 0;
					else
						visited[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}

		result = Integer.MAX_VALUE;
		bfs();

		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
}