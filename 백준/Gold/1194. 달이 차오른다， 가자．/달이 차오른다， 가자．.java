import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static char[][] map;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int r, c, depth, keyMask;

		public Node(int r, int c, int depth, int keyMask) {
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.keyMask = keyMask;
		}
	}

	public static int bfs(int startR, int startC) {
		Queue<Node> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][64]; // 64 = 2^6 (a~f 키)

		q.add(new Node(startR, startC, 0, 0));
		visited[startR][startC][0] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (map[cur.r][cur.c] == '1') {
				return cur.depth;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];
				int newMask = cur.keyMask;

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (map[nr][nc] == '#')
					continue;

				char ch = map[nr][nc];
				if ('A' <= ch && ch <= 'F') {
					if ((newMask & (1 << (ch - 'A'))) == 0)
						continue;
				}
				if ('a' <= ch && ch <= 'f') {
					newMask |= (1 << (ch - 'a'));
				}

				if (!visited[nr][nc][newMask]) {
					visited[nr][nc][newMask] = true;
					q.add(new Node(nr, nc, cur.depth + 1, newMask));
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		int startR = 0, startC = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') {
					startR = i;
					startC = j;
					map[i][j] = '.';
				}
			}
		}

		int result = bfs(startR, startC);
		
		System.out.println(result);
	}
}