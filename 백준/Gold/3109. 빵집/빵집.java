import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int R, C;
	private static char[][] map;
	private static int result;

	public static void dfs(int cnt, int row) {
		if (cnt == C - 2) {
			result++;
			return;
		}

		for (int i = row - 1; i <= row + 1; i++) {
			if (i >= 0 && i < R) {
				if (map[i][cnt + 1] == '.') {
					map[i][cnt + 1] = 'X';

					int temp = result;
					dfs(cnt + 1, i);

					if (temp != result)
						break;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		result = 0;

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			dfs(0, i);
		}

		System.out.println(result);
	}
}