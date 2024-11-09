import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			switch (command) {
			case 1:
				int x = Integer.parseInt(st.nextToken());
				stack.push(x);
				break;
			case 2:
				int result2 = stack.isEmpty() ? -1 : stack.pop();
				sb.append(result2).append("\n");
				break;
			case 3:
				sb.append(stack.size()).append("\n");
				break;
			case 4:
				int result4 = stack.isEmpty() ? 1 : 0;
				sb.append(result4).append("\n");
				break;
			case 5:
				int result5 = stack.isEmpty() ? -1 : stack.peek();
				sb.append(result5).append("\n");
				break;
			}

		}

		System.out.println(sb);

	}

}