import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] grid = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;

			for (int j = 0; j < n; j++) {
				int pre = 0;

				for (int i = 0; i < n; i++) {
					if (grid[i][j] == 2 && pre == 1) {
						count++;
					}

					if (grid[i][j] != 0)
						pre = grid[i][j];
				}
			}

			sb.append("#").append(testCase).append(" ").append(count).append("\n");

		}

		System.out.println(sb);

	}

}