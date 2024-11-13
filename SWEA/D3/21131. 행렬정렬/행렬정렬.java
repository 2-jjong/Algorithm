import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\1_sample_input.txt"));
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

			int transposeCount = 0;

            for (int i = n; i > 0; i--) {
                if (grid[0][i - 1] != i) {
                    transposeSubgrid(grid, i);
                    transposeCount++;
                }
            }

			sb.append(transposeCount).append("\n");

		}

		System.out.println(sb);

	}

	public static int[][] transposeSubgrid(int[][] grid, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				int temp = grid[i][j];
				grid[i][j] = grid[j][i];
				grid[j][i] = temp;
			}
		}

		return grid;
	}

}