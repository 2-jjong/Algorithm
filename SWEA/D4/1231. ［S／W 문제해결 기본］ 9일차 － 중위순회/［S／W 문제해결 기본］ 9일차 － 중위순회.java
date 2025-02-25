import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static char[] tree;
	private static StringBuilder sb;

	public static void inOrder(int index) {
		if (index > N)
			return;

		inOrder(index * 2);
		sb.append(tree[index]);
		inOrder(index * 2 + 1);
	}

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			/**
			 * 1. 입력 파일 객체화
			 */

			N = Integer.parseInt(in.readLine());
			tree = new char[N + 1];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int index = Integer.parseInt(st.nextToken());

				tree[index] = st.nextToken().charAt(0);
			}

			/**
			 * 2. 알고리즘 풀기
			 */

			inOrder(1);

			/**
			 * 3. 정답 출력
			 */

			sb.append("\n");

		}

		System.out.println(sb);
	}
}