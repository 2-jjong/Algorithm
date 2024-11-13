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
			int[][] triangle = new int[n][n];

			for (int i = 0; i < n; i++) {
				triangle[i][0] = 1;
				triangle[i][i] = 1;

				for (int j = 1; j < i; j++) {
					triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
				}
			}

			sb.append("#").append(testCase + 1).append("\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					sb.append(triangle[i][j]).append(" ");
				}
				sb.append("\n");
			}

		}

		System.out.println(sb);

	}

}