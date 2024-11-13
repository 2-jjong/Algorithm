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
			String s = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			int answer = s.indexOf("o");

			if (k > 0) {
				if (k % 2 == 0)
					answer = answer == 1 ? 1 : 0;
				else
					answer = answer == 1 ? 0 : 1;
			}

			sb.append("#").append(testCase + 1).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

}