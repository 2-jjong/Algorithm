import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			String S = br.readLine();
			String E = br.readLine();
			String result = new String(E);

			while (result.length() > S.length()) {
				char c = result.charAt(result.length() - 1);

				if (c == 'X')
					result = minusX(result);
				else if (c == 'Y')
					result = minusY(result);

			}

			sb.append("#").append(testCase + 1).append(" ");

			if (S.equals(result))
				sb.append("Yes").append("\n");
			else
				sb.append("No").append("\n");

		}

		System.out.println(sb);

	}

	public static String minusX(String str) {
		return str.substring(0, str.length() - 1);
	}

	public static String minusY(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str.substring(0, str.length() - 1)).reverse();
		return sb.toString();
	}

}