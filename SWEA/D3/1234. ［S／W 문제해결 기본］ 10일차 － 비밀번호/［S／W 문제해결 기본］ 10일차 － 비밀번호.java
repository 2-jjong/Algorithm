import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

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

			String[] split = in.readLine().split(" ");
			int N = Integer.parseInt(split[0]);
			char[] input = split[1].toCharArray();
			Stack<Character> stack = new Stack<>();

			/**
			 * 2. 알고리즘 풀기
			 */

			for (int i = 0; i < input.length; i++) {
				char currentInput = input[i];

				if (!stack.isEmpty() && stack.peek() == currentInput)
					stack.pop();
				else
					stack.push(currentInput);
			}

			/**
			 * 3. 정답 출력
			 */

			StringBuilder answer = new StringBuilder();
			
			while (!stack.isEmpty()) {
				answer.append(stack.pop());
			}

			sb.append(answer.reverse()).append("\n");

		}

		System.out.println(sb);
	}

}