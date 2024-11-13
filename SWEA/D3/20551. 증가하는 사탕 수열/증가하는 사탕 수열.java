import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int answer = 0;

			if (b < 2 || c < 3) {
				answer = -1;
			} else {
				while (b >= c) {
					b--;
					answer++;
				}

				while (a >= b) {
					a--;
					answer++;
				}
			}

			sb.append("#").append(testCase + 1).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

}