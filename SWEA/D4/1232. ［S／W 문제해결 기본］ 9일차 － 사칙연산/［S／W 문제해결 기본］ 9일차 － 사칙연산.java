import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static Node[] tree;

	public static int postOrder(Node node) {
		if (node == null) {
			return -1;
		}

		int left = postOrder(node.left);
		int right = postOrder(node.right);

		String value = node.value;
		
		if (value.equals("+"))
			return left + right;
		else if (value.equals("-"))
			return left - right;
		else if (value.equals("*"))
			return left * right;
		else if (value.equals("/"))
			return left / right;
		else
			return Integer.parseInt(value);
	}

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			/**
			 * 1. 입력 파일 객체화
			 */

			N = Integer.parseInt(in.readLine());
			tree = new Node[N + 1];

			for (int i = 1; i < N + 1; i++) {
				tree[i] = new Node();
			}

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());

				int index = Integer.parseInt(st.nextToken());

				tree[index].value = st.nextToken();

				if (st.hasMoreTokens()) {
					int leftIndex = Integer.parseInt(st.nextToken());
					tree[index].left = tree[leftIndex];
				}

				if (st.hasMoreTokens()) {
					int rightIndex = Integer.parseInt(st.nextToken());
					tree[index].right = tree[rightIndex];
				}
			}

			/**
			 * 2. 알고리즘 풀기
			 */

			int answer = postOrder(tree[1]);

			/**
			 * 3. 정답 출력
			 */

			sb.append(answer).append("\n");

		}

		System.out.println(sb);
	}

}

class Node {
	String value;
	Node left;
	Node right;
}