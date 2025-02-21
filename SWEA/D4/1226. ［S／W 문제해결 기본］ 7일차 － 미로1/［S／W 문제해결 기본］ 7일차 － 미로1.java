import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	private static int[][] grid;
	private static boolean[][] visited;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static boolean check(int x, int y) {
		if (x < 0 || x >= 16)
			return false;
		if (y < 0 || y >= 16)
			return false;
		if (visited[x][y])
			return false;
		if (grid[x][y] == 1)
			return false;
		return true;
	}

	// BFS
	public static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();

		visited[x][y] = true;

		queue.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] coordinate = queue.poll();
			int currentX = coordinate[0];
			int currentY = coordinate[1];

			if (grid[currentX][currentY] == 3) {
				return 1;
			}

			for (int k = 0; k < 4; k++) {
				int nx = currentX + dx[k];
				int ny = currentY + dy[k];

				if (check(nx, ny)) {
					visited[nx][ny] = true;
					queue.add(new int[] { nx, ny });
				}
			}

		}

		return 0;
	}

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#" + testCase + " ");

			/**
			 * 1. 입력 파일 객체화
			 */

			grid = new int[16][16];
			visited = new boolean[16][16];

			in.readLine();

			for (int i = 0; i < 16; i++) {
				String line = in.readLine();

				for (int j = 0; j < 16; j++) {
					grid[i][j] = (int) line.charAt(j) - '0';
				}
			}

			/**
			 * 2. 알고리즘 풀기
			 */

			// 출발점 1,1부터 DFS 탐색 시작
			int answer = bfs(1, 1);

			/**
			 * 3. 정답 출력
			 */

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}