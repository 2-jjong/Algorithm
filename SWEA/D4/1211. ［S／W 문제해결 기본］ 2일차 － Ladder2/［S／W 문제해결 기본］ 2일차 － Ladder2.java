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
			int[] distance = new int[100];

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 0;

			for (int i = 0; i < 100; i++) {
				if (grid[0][i] == 1) {
					distance[i] = ladder(grid, i);
					if (distance[answer] >= distance[i])
						answer = i;
				}
			}

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}

		System.out.print(sb);
	}

	public static int ladder(int[][] grid, int start) {
		int x = start, y = 0;
		int distance = 0;

		while (y < 99) {
			if (x > 0 && grid[y][x - 1] == 1) {
				while (x > 0 && grid[y][x - 1] == 1) {
					x--;
					distance++;
				}
			} else if (x < 99 && grid[y][x + 1] == 1) {
				while (x < 99 && grid[y][x + 1] == 1) {
					x++;
					distance++;
				}
			}

			y++;
			distance++;
		}

		return distance;
	}

}