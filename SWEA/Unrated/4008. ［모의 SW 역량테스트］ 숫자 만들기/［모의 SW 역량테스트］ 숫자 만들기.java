import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static int[] number;
	private static int[] op;
	private static int min;
	private static int max;

	public static void calc(int index, int total) {
		if (index >= N) {
			min = Math.min(min, total);
			max = Math.max(max, total);
			return;
		}

		if (op[0] > 0) {
			op[0]--;
			calc(index + 1, total + number[index]);
			op[0]++;
		}

		if (op[1] > 0) {
			op[1]--;		
			calc(index + 1, total - number[index]);
			op[1]++;
		}

		if (op[2] > 0) {
			op[2]--;
			calc(index + 1, total * number[index]);
			op[2]++;
		}

		if (op[3] > 0) {
			op[3]--;
			calc(index + 1, total / number[index]);
			op[3]++;
		}
	}

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			/**
			 * 1. 입력 파일 객체화
			 */

			N = Integer.parseInt(br.readLine());
			number = new int[N];
			op = new int[4];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}

			/**
			 * 2. 알고리즘 풀기
			 */

			calc(1, number[0]);

			/**
			 * 3. 정답 출력
			 */

			sb.append(max - min).append("\n");

		}

		System.out.println(sb);
	}
}