import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			int n = Integer.parseInt(br.readLine());
			String[] dp = new String[n + 1];

			if (n >= 1)
				dp[1] = "impossible";
			if (n >= 2)
				dp[2] = "AB";
			if (n >= 3)
				dp[3] = "AAB";

			for (int i = 4; i <= n; i++) {
				if (dp[i - 3].equals("impossible"))
					dp[i] = "impossible";
				else
					dp[i] = dp[i - 3] + "AAB";
			}

			sb.append(dp[n]).append("\n");

		}

		System.out.println(sb);

	}

}