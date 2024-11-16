import java.util.*;
import java.io.*;

public class Solution {
	static class Node {
		char value;
		int lfet;
		int right;

		public Node(char value, int left, int right) {
			this.value = value;
			this.lfet = left;
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
				char value = st.nextToken().charAt(0);
				int left = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;
				int right = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;

				tree[i] = new Node(value, left, right);
			}

			sb.append("#").append(testCase).append(" ");
			inOrder(1);
			sb.append("\n");

		}

		System.out.println(sb);

	}

	public static void inOrder(int vertex) {
		if (vertex == -1)
			return;

		inOrder(tree[vertex].lfet);
		sb.append(tree[vertex].value);
		inOrder(tree[vertex].right);
	}

}