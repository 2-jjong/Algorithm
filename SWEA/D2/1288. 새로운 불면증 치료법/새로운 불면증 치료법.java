import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			String n = br.readLine();
			boolean[] numCheck = new boolean[10];
			String numStr = "0";
			int count = 0;

			while (count < 10) {
				int number = Integer.parseInt(numStr) + Integer.parseInt(n);
				numStr = String.valueOf(number);

				for (char c : numStr.toCharArray()) {
					int temp = c - '0';

					if (!numCheck[temp]) {
						numCheck[temp] = true;
						count++;
					}
				}
			}

			sb.append("#").append(testCase + 1).append(" ").append(numStr).append("\n");

		}

		System.out.println(sb);

	}

}