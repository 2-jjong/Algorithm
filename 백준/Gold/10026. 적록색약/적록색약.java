import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static int colorSection;
	public static int colorBlindSection;

	public static boolean check(int r, int c) {
		if (r < 0 || c < 0)
			return false;
		if (r >= N || c >= N)
			return false;
		if (visited[r][c])
			return false;
		return true;
	}

	public static void dfs(int r, int c) {
		char color = map[r][c];
		visited[r][c] = true;

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (check(nr, nc) && map[nr][nc] == color) {
				dfs(nr, nc);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		colorSection = 0;
		colorBlindSection = 0;

		// 일반인
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					colorSection++;
				}
			}
		}

		// 적록색약
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					colorBlindSection++;
				}
			}
		}

		System.out.println(colorSection + " " + colorBlindSection);
	}
}