import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	private static int[][] grid;
	private static boolean[][] visited;
	private static int[] di = { -1, 1, 0, 0 };
	private static int[] dj = { 0, 0, -1, 1 };
	private static boolean result;

	// DFS
	public static void dfs(int i, int j) {
		visited[i][j] = true;
		
		for (int k = 0; k < di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			
			if(grid[ni][nj] == 3) {
				result = true;
				return;
			}

			if (!visited[ni][nj] && grid[ni][nj] == 0) {
				dfs(ni, nj);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		/**
		 * 0. 입력파일 읽어들이기
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#" + testCase + " ");

			// 알고리즘 코드 작성하기
			/**
			 * 1. 입력 파일 객체화
			 */

			grid = new int[16][16];
			visited = new boolean[16][16];
			result = false;

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

			dfs(1,1);
			
			/**
			 * 3. 정답 출력
			 */
			
			int answer = result ? 1 : 0;
			
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}