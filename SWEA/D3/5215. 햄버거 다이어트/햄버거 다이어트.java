import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int N, L;
	private static int[] tastes;
	private static int[] calories;
	private static boolean[] selected;
	private static int answer;

	public static void subSet(int index, int calorie, int taste) {
		if (index == N) {
			if (calorie <= L) {
				answer = Math.max(answer, taste);
			}
			return;
		}

		selected[index] = true;
		subSet(index + 1, calorie + calories[index], taste + tastes[index]);

		selected[index] = false;
		subSet(index + 1, calorie, taste);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			tastes = new int[N];
			calories = new int[N];
			selected = new boolean[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				tastes[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}

			answer = Integer.MIN_VALUE;
			subSet(0, 0, 0);

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

}