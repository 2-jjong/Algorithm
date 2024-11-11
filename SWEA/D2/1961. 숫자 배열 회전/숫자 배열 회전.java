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

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] rotation90 = rotation(grid);
			int[][] rotation180 = rotation(rotation90);
			int[][] rotation270 = rotation(rotation180);

			sb.append("#").append(testCase + 1).append("\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(rotation90[i][j]);
				}
				sb.append(" ");
				
				for (int j = 0; j < n; j++) {
					sb.append(rotation180[i][j]);
				}
				sb.append(" ");
				
				for (int j = 0; j < n; j++) {
					sb.append(rotation270[i][j]);
				}
				sb.append("\n");
			}

		}

		System.out.println(sb);

	}

	public static int[][] rotation(int[][] grid) {
		int[][] newGrid = new int[grid.length][grid.length];
		int row = 0;
		int column = 0;

		for (int j = 0; j < newGrid.length; j++) {
			for (int i = newGrid.length - 1; i >= 0; i--) {
				newGrid[row][column++] = grid[i][j];
			}
			row++;
			column = 0;
		}

		return newGrid;
	}

}