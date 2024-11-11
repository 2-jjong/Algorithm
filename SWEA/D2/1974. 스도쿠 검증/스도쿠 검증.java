import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			int[][] grid = new int[9][9];

			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean isValid = true;

			for (int i = 0; i < 9; i++) {
				if (!checkUnique(grid[i])) {
					isValid = false;
					break;
				}
			}

			for (int j = 0; j < 9 && isValid; j++) {
				int[] column = new int[9];

				for (int i = 0; i < 9; i++) {
					column[i] = grid[i][j];
				}

				if (!checkUnique(column)) {
					isValid = false;
					break;
				}
			}

			for (int i = 0; i < 9 && isValid; i = i + 3) {
				for (int j = 0; j < 9; j = j + 3) {
					if (!checkSubGrid(grid, i, j)) {
						isValid = false;
						break;
					}
				}
			}

			if (isValid)
				sb.append("#").append(testCase + 1).append(" ").append(1).append("\n");
			else
				sb.append("#").append(testCase + 1).append(" ").append(0).append("\n");
		}

		System.out.println(sb);

	}

	public static boolean checkUnique(int[] arr) {
		boolean[] numCheck = new boolean[10];

		for (int i = 0; i < 9; i++) {
			int num = arr[i];

			if (num < 1 || num > 9 || numCheck[num])
				return false;

			numCheck[num] = true;
		}

		return true;
	}

	public static boolean checkSubGrid(int[][] grid, int row, int column) {
		boolean[] numCheck = new boolean[10];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int num = grid[row + i][column + j];

				if (num < 1 || num > 9 || numCheck[num])
					return false;

				numCheck[num] = true;
			}
		}

		return true;
	}

}