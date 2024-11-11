import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int k = 0; k < t; k++) {
			String str = br.readLine();
			int i = 0;
			int j = str.length() - 1;
			int answer = 1;

			while (i < j) {
				char first = str.charAt(i++);
				char last = str.charAt(j--);

				if (first != last)
					answer = 0;
			}

			sb.append("#").append(k + 1).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);

	}

}