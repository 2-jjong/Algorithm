import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	// 전역변수
	private static int[] counter; // 빈도수를 저장하는 배열(인덱스 번호는 점수)

	public static void main(String[] args) throws Exception {
		/**
		 * 0. 입력파일 읽어들이기
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			// 알고리즘 코드 작성하기
			/**
			 * 1. 입력 파일 객체화
			 */
			in.readLine(); // 테스트케이스 번호 건너뛰기
			String[] scores = in.readLine().split(" ");
			counter = new int[101];

			/**
			 * 2. 알고리즘 풀기
			 */
			for (int i = 0; i < scores.length; i++) {
				int score = Integer.parseInt(scores[i]); // 문자열을 정수로 변환
				counter[score]++; // 점수 카운팅
			}

			/**
			 * 3. 정답 출력
			 */
			int max = Integer.MIN_VALUE;
			int answer = -1;
			for (int score = 0; score <= 100; score++) {
				if (max <= counter[score]) {
					max = counter[score];
					answer = score;
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

}