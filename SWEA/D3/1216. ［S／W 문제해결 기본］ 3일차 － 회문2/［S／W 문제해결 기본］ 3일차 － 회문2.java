import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());
			char[][] grid = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					grid[i][j] = str.charAt(j);
				}
			}

			int length = 1;

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int k = j + 1; k < 100; k++) {
						String rowStr = new String(grid[i], j, k - j + 1);
						length = Math.max(length, palindromeCheck(rowStr));
					}
				}
			}

			for (int j = 0; j < 100; j++) {
				for (int i = 0; i < 100; i++) {
					for (int k = i + 1; k < 100; k++) {
						StringBuilder colStr = new StringBuilder();

						for (int m = i; m <= k; m++) {
							colStr.append(grid[m][j]);
						}

						length = Math.max(length, palindromeCheck(colStr.toString()));
					}
				}
			}

			sb.append("#").append(n).append(" ").append(length).append("\n");
		}

		System.out.print(sb);
	}

	public static int palindromeCheck(String str) {
		int i = 0;
		int j = str.length() - 1;

		while (i < j) {
			if (str.charAt(i++) != str.charAt(j--)) {
				return 0;
			}
		}

		return str.length();
	}

}