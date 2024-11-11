import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int k = 0; k < t; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] grid = new int[n + 1][n + 1];
			int[][] prefixSum = new int[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					prefixSum[i][j] = grid[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
				}
			}

			int answer = 0;
			for (int i = 1; i <= n - m + 1; i++) {
				for (int j = 1; j <= n - m + 1; j++) {
					int flies = prefixSum[i + m - 1][j + m - 1] - prefixSum[i + m - 1][j - 1]
							- prefixSum[i - 1][j + m - 1] + prefixSum[i - 1][j - 1];
					answer = Math.max(answer, flies);
				}
			}

			sb.append("#").append(k + 1).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);

	}

}