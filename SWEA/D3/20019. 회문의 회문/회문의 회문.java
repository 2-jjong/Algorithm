import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			String str = br.readLine();
			boolean strCheck = palindromeCheck(str);
			boolean leftStrCheck = palindromeCheck(str.substring(0, str.length() / 2));
			boolean rightStrCheck = palindromeCheck(str.substring((str.length() / 2) + 1, str.length()));
			String answer = "NO";

			if (strCheck && leftStrCheck && rightStrCheck)
				answer = "YES";

			sb.append("#").append(testCase + 1).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

	public static boolean palindromeCheck(String str) {
		int i = 0;
		int j = str.length() - 1;

		while (i < j) {
			char first = str.charAt(i++);
			char last = str.charAt(j--);

			if (first != last)
				return false;
		}

		return true;
	}

}