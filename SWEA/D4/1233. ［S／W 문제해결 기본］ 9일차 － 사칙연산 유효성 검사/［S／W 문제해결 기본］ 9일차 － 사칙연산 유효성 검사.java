import java.util.*;
import java.io.*;

public class Solution {
	static class Node {
		String value;
		int left;
		int right;

		public Node(String value, int left, int right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

	}

	static Node[] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());
			tree = new Node[n + 1];

			for (int i = 1; i <= n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int vertex = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				int left = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;
				int right = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;

				tree[i] = new Node(value, left, right);
			}

			boolean result = preOrder(1);

			int answer = result ? 1 : 0;

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

	public static boolean preOrder(int vertex) {
		Node node = tree[vertex];

		if ((node.value.equals("+") || node.value.equals("-") || node.value.equals("*") || node.value.equals("/"))
				&& (node.left != -1 && node.right != -1)) {
			if (preOrder(node.left) && preOrder(node.right)) {
				return true;
			}
		} else {
			if (node.left == -1 && node.right == -1) {
				return true;
			}
		}

		return false;
	}

}