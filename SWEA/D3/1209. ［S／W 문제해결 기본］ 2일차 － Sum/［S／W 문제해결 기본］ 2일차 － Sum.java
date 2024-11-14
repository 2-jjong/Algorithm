import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] grid = new int[100][100];
			int maxSum = 0;
			int diagSum1 = 0;
			int diagSum2 = 0;

			for (int i = 0; i < 100; i++) {
				int rowSum = 0;
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					rowSum += grid[i][j];
				}

				maxSum = Math.max(maxSum, rowSum);
			}

			for (int j = 0; j < 100; j++) {
				int colSum = 0;
				for (int i = 0; i < 100; i++) {
					colSum += grid[i][j];
				}
				maxSum = Math.max(maxSum, colSum);

				diagSum1 += grid[j][j];
				diagSum2 += grid[j][99 - j];
			}

			maxSum = Math.max(maxSum, diagSum1);
			maxSum = Math.max(maxSum, diagSum2);

			sb.append("#").append(testCase).append(" ").append(maxSum).append("\n");
		}

		System.out.print(sb);
	}

}