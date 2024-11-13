import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int answer = 0;

			for (int i = 1; i <= n; i++) {
				answer += i;

				if (answer == p) {
					answer--;
				}
			}

			sb.append(answer).append("\n");

		}

		System.out.println(sb);

	}

}