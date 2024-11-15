import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			int length = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean isValid = true;

			if (length % 2 == 1) {
				sb.append("#").append(testCase).append(" ").append(0).append("\n");
				continue;
			}

			for (char c : str.toCharArray()) {
				if (c == '(' || c == '{' || c == '[' || c == '<') {
					stack.push(c);
				} else {
					if (stack.isEmpty()) {
						isValid = false;
						break;
					}

					char last = stack.pop();
					if (!isPair(last, c)) {
						isValid = false;
						break;
					}
				}
			}

			if (!stack.isEmpty()) {
				isValid = false;
			}

			int answer = isValid ? 1 : 0;

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

	private static boolean isPair(char open, char close) {
		return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']')
				|| (open == '<' && close == '>');
	}

}