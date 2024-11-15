import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] grid = new int[16][16];
			boolean[][] visited = new boolean[16][16];
			int startRow = 0, startCol = 0, targetRow = 0, targetCol = 0;

			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				char[] c = str.toCharArray();

				for (int j = 0; j < 16; j++) {
					grid[i][j] = c[j] - '0';

					if (grid[i][j] == 2) {
						startRow = i;
						startCol = j;
					} else if (grid[i][j] == 3) {
						targetRow = i;
						targetCol = j;
					}
				}
			}

			dfs(grid, visited, startRow, startCol);

			int answer = visited[targetRow][targetCol] ? 1 : 0;

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

	public static void dfs(int[][] grid, boolean[][] visited, int row, int col) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		int nx, ny;

		visited[row][col] = true;

		for (int i = 0; i < 4; i++) {
			nx = row + dx[i];
			ny = col + dy[i];

			if (nx >= 0 && ny >= 0 && nx < 16 && ny < 16) {
				if ((grid[nx][ny] == 0 || grid[nx][ny] == 3) && !visited[nx][ny])
					dfs(grid, visited, nx, ny);
			}
		}
	}

}