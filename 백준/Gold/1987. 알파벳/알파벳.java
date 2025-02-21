import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static char[][] arr;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static int r, c;
	static Set<Character> check = new HashSet<>();
	static int cnt = 1;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nums = br.readLine().split(" ");
		r = Integer.parseInt(nums[0]);
		c = Integer.parseInt(nums[1]);

		arr = new char[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		check.add(arr[0][0]);
		dfs(0, 0);
		
		System.out.println(cnt);

	}

	public static void dfs(int x, int y) {
		cnt = Math.max(cnt, check.size());

		for (int k = 0; k < 4; k++) {
			int X = x + dx[k];
			int Y = y + dy[k];
			if (X >= 0 && Y >= 0 && X < r && Y < c && !visited[X][Y]) {
				if (!check.contains(arr[X][Y])) {
					check.add(arr[X][Y]);
					dfs(X, Y);
					check.remove(arr[X][Y]);
				}
			}
		}
	}
}