import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());
			char[][] grid = new char[8][8];

			for (int i = 0; i < 8; i++) {
				String str = br.readLine();
				for (int j = 0; j < 8; j++) {
					grid[i][j] = str.charAt(j);
				}
			}

			int count = 0;

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - n + 1; j++) {
					String rowStr = new String(grid[i], j, n);
					count += palindromeCheck(rowStr);
				}
			}

			for (int j = 0; j < 8; j++) {
				for (int i = 0; i < 8 - n + 1; i++) {
					StringBuilder colStr = new StringBuilder();

					for (int k = i; k < i + n; k++) {
						colStr.append(grid[k][j]);
					}

					count += palindromeCheck(colStr.toString());
				}
			}

			sb.append("#").append(testCase).append(" ").append(count).append("\n");
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
		return 1;
	}

}