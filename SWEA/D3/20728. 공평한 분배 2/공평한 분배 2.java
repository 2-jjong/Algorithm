import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\sin.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] pocket = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				pocket[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(pocket);

			int answer = Integer.MAX_VALUE;

			if (n == k) {
				answer = pocket[n - 1] - pocket[0];
			} else {
				for (int i = 0; i < n - k + 1; i++) {
					answer = Math.min(answer, pocket[i + k - 1] - pocket[i]);
				}
			}

			sb.append("#").append(testCase + 1).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

}