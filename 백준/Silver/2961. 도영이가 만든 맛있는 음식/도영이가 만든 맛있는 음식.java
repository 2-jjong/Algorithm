import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int result;
	private static int[][] food;
	private static boolean[] isSelected;

	// cnt: 직전까지 고려한 원소의 개수
	// sourTotal: 신맛 곱
	// bitterTotal: 쓴맛 합
	// selectedCount: 선택된 음식의 개수 합
	private static void generatedSubSet(int cnt, int sourTotal, int bitterTotal, int selectedCount) {
		// 기저부분
		if (cnt == N) {
			if (selectedCount > 0)
				result = Math.min(result, Math.abs(sourTotal - bitterTotal));

			return;
		}

		// 유도부분
		isSelected[cnt] = true;
		generatedSubSet(cnt + 1, sourTotal * food[cnt][0], bitterTotal + food[cnt][1], selectedCount + 1);

		if (N > 1) {
			isSelected[cnt] = false;
			generatedSubSet(cnt + 1, sourTotal, bitterTotal, selectedCount);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		result = Integer.MAX_VALUE;

		food = new int[N][2];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}

		generatedSubSet(0, 1, 0, 0);

		System.out.println(result);
	}

}