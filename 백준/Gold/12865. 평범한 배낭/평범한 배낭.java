import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		// 0은 무게 1은 가치
		int[][] items = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] DP = new int[N + 1][W + 1];
		for (int curItem = 1; curItem <= N; curItem++) {
			int itemWeight = items[curItem][0]; // 현재 아이템 무게
			int itemProfit = items[curItem][1]; // 현재 아이템 가치

			for (int curWeight = 1; curWeight <= W; curWeight++) {
				if (itemWeight > curWeight) {
					DP[curItem][curWeight] = DP[curItem - 1][curWeight];
				} else {
					DP[curItem][curWeight] = Math.max(itemProfit + DP[curItem - 1][curWeight - itemWeight],
							DP[curItem - 1][curWeight]);
				}
			}
		}

		System.out.println(DP[N][W]);
	}
}
