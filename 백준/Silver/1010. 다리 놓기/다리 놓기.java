import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[][] memo;

	private static int bino(int n, int k) {
		if (k == 0 || n == k) {
			return 1;
		}

		if (memo[n][k] == -1) {
			memo[n][k] = bino(n - 1, k - 1) + bino(n - 1, k);
		}

		return memo[n][k];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			memo = new int[M + 1][N + 1];
			for (int i = 0; i <= M; i++) {
				Arrays.fill(memo[i], -1);
			}

			sb.append(bino(M, N)).append("\n");
		}

		System.out.println(sb);
	}
}
