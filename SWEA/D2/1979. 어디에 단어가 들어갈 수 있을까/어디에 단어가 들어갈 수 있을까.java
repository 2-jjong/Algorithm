import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] grid = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i = 0; i < n; i++) {
				int sum = 0;

				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 1)
						sum++;
					else {
						if (sum == k)
							count++;
						sum = 0;
					}
				}

				if (sum == k)
					count++;
			}

			for (int i = 0; i < n; i++) {
				int sum = 0;

				for (int j = 0; j < n; j++) {
					if (grid[j][i] == 1)
						sum++;
					else {
						if (sum == k)
							count++;
						sum = 0;
					}
				}

				if (sum == k)
					count++;
			}

			sb.append("#").append(testCase + 1).append(" ").append(count).append("\n");
		}

		System.out.println(sb);

	}

}