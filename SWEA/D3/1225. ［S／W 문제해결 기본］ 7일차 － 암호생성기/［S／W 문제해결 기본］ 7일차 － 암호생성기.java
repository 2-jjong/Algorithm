import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
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

			int N = Integer.parseInt(in.readLine());
			String[] split = in.readLine().split(" ");
			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(split[i]));
			}

			/**
			 * 2. 알고리즘 풀기
			 */

			int cycle = 1;

			while (true) {
				int num = queue.poll();

				num = (num - cycle) < 0 ? 0 : num - cycle;

				queue.add(num);

				if (num == 0) {
					break;
				}

				cycle = cycle % 5 + 1;
			}

			/**
			 * 3. 정답 출력
			 */
			
			while(!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}
}