import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] grid = new int[n][n];
			int[] dx = { 0, 1, 0, -1 };
			int[] dy = { 1, 0, -1, 0 };
			int direction = 0;
			int num = 1;
			int x = 0, y = 0, nx, ny;

			while (num <= n * n) {
				grid[x][y] = num++;

				nx = x + dx[direction];
				ny = y + dy[direction];

				if (nx >= n || ny >= n || nx < 0 || ny < 0 || grid[nx][ny] != 0) {
					direction = (direction + 1) % 4;
				}

				x += dx[direction];
				y += dy[direction];
			}

			sb.append("#").append(testCase + 1).append("\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(grid[i][j]);

					if (j < n)
						sb.append(" ");
				}
				sb.append("\n");
			}

		}

		System.out.println(sb);

	}

}