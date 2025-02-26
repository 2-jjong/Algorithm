import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int[] plan;
	private static int[] price;

	public static int priceSum(int month, int totalPrice) {
		if (month > 12) {
			return totalPrice;
		}

		int minPrice = Integer.MAX_VALUE;

		if (plan[month] > 0) {
			minPrice = Math.min(minPrice, priceSum(month + 1, totalPrice + plan[month] * price[0]));

			minPrice = Math.min(minPrice, priceSum(month + 1, totalPrice + price[1]));

			minPrice = Math.min(minPrice, priceSum(month + 3, totalPrice + price[2]));  
		} else {
			minPrice = Math.min(minPrice, priceSum(month + 1, totalPrice));
		}

		return minPrice;
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

			price = new int[4];
			plan = new int[13];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			/**
			 * 2. 알고리즘 풀기
			 */

			int answer = Math.min(priceSum(1, 0), price[3]);

			/**
			 * 3. 정답 출력
			 */

			sb.append(answer).append("\n");

		}

		System.out.println(sb);
	}
}