import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		/**
		 * 0. 입력파일 읽어들이기
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			// 알고리즘 코드 작성하기
			/**
			 * 1. 입력 파일 객체화
			 */
			in.readLine();
			String[] buildings = in.readLine().split(" ");

			/**
			 * 2. 알고리즘 풀기
			 */
			int result = 0;

			for (int i = 2; i < buildings.length - 2; i++) {
				int height = Integer.parseInt(buildings[i]);
				int max = Integer.MIN_VALUE;

				for (int j = i - 2; j <= i + 2; j++) {
					if (j != i) {
						int temp = Integer.parseInt(buildings[j]);
						max = Math.max(max, temp);
					}
				}

				if (height > max) {
					result += height - max;
				}
			}

			/**
			 * 3. 정답 출력
			 */
			sb.append(result).append("\n");
		}

		System.out.println(sb);

	}

}