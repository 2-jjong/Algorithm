import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] memorys = new int[N + 1];
		int[] costs = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			memorys[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int totalCost = 0;
		for (int i = 1; i <= N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());

			totalCost += costs[i];
		}

		int[][] DP = new int[N + 1][totalCost + 1];

		int answer = Integer.MAX_VALUE;

		for (int curApp = 1; curApp <= N; curApp++) {
			int appMemory = memorys[curApp]; // 현재 앱의 메모리
			int appCost = costs[curApp]; // 현재 앱의 재실행 비용

			for (int curCost = 0; curCost <= totalCost; curCost++) {
				if (appCost > curCost) {
					DP[curApp][curCost] = DP[curApp - 1][curCost];
				} else {
					DP[curApp][curCost] = Math.max(appMemory + DP[curApp - 1][curCost - appCost],
							DP[curApp - 1][curCost]);
				}

				if (DP[curApp][curCost] >= M) {
					answer = Math.min(answer, curCost);
				}
			}
		}

		System.out.println(answer);
	}
}
