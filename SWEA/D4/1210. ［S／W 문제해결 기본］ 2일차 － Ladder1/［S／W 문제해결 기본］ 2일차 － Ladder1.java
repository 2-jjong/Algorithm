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
			int index = 0;

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());

					if (grid[i][j] == 2)
						index = j;
				}
			}

			int answer = ladder(grid, index);

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}

		System.out.print(sb);
	}

	public static int ladder(int[][] grid, int start) {
		int x = 99, y = start;

		while (x > 0) {
			if (y > 0 && grid[x][y - 1] == 1) {
				while (y > 0 && grid[x][y - 1] == 1) {
					y--;
				}
			}

			else if (y < 99 && grid[x][y + 1] == 1) {
				while (y < 99 && grid[x][y + 1] == 1) {
					y++;
				}
			}

			x--;
		}

		return y;
	}

}