import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 0은 가로 1은 세로 2는 대각선
		int[][][] dp = new int[N][N][3];

		// 초기 파이프는 가로
		dp[0][1][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				// 벽이면 건너뛰기
				if (map[i][j] == 1)
					continue;

				if (j - 1 >= 0)
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
				if (i - 1 >= 0)
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
				if (i - 1 >= 0 && j - 1 >= 0 && map[i-1][j] != 1 && map[i][j-1] != 1)
					dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
			}
		}

		int answer = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];

		System.out.println(answer);

	}
}
