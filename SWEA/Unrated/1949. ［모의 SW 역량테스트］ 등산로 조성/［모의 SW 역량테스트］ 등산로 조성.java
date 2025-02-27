import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static int[][] grid;
	private static boolean[][] visited;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int maxPeak;
	private static int maxLoadCount;

	public static boolean check(int x, int y) {
		if (x < 0 || y < 0)
			return false;
		if (x >= N || y >= N)
			return false;
		if (visited[x][y])
			return false;

		return true;
	}

	public static void calcLoad(int x, int y, int loadCount, int k) {

		visited[x][y] = true;
		maxLoadCount = Math.max(maxLoadCount, loadCount);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (check(nx, ny)) {
				if (grid[nx][ny] >= grid[x][y]) {
					if (k > 0 && grid[nx][ny] - k < grid[x][y]) {
						int original = grid[nx][ny];

						grid[nx][ny] = grid[x][y] - 1;
						calcLoad(nx, ny, loadCount + 1, 0);
						grid[nx][ny] = original;
					} else {
						continue;
					}

				} else {
					calcLoad(nx, ny, loadCount + 1, k);
				}
			}
		}

		visited[x][y] = false;
	}

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
			N = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			maxLoadCount = Integer.MIN_VALUE;
			grid = new int[N][N];
			visited = new boolean[N][N];

			maxPeak = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					maxPeak = Math.max(maxPeak, grid[i][j]);
				}
			}

			/**
			 * 2. 알고리즘 풀기
			 */

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (grid[i][j] == maxPeak)
						calcLoad(i, j, 1, k);
				}
			}

			/**
			 * 3. 정답 출력
			 */

			int answer = maxLoadCount;

			sb.append(answer).append("\n");

		}

		System.out.println(sb);
	}
}