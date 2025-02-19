import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

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

			int N = Integer.parseInt(in.readLine());
			char[] input = in.readLine().toCharArray();
			Deque<Character> deque = new LinkedList<>();
			boolean result = true;

			/**
			 * 2. 알고리즘 풀기
			 */

			for (int i = 0; i < N; i++) {
				char currentInput = input[i];

				if (currentInput == ')' || currentInput == '}' || currentInput == ']' || currentInput == '>') {
					if (deque.size() > 0) {
						char lastChar = deque.removeLast();

						switch (currentInput) {
						case ')':
							if (lastChar != '(')
								result = false;
							break;
						case '}':
							if (lastChar != '{')
								result = false;
							break;
						case ']':
							if (lastChar != '[')
								result = false;
							break;
						case '>':
							if (lastChar != '<')
								result = false;
							break;
						}
					} else {
						result = false;
						break;
					}
				} else {
					deque.addLast(currentInput);
				}

			}

			if (!deque.isEmpty()) {
				result = false;
			}

			/**
			 * 3. 정답 출력
			 */

			int answer = result ? 1 : 0;

			sb.append(answer).append("\n");

		}

		System.out.println(sb);
	}
}