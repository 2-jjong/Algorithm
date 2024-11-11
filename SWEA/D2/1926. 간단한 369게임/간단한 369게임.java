import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\1_sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			boolean flag = true;
			String numStr = Integer.toString(i);
			for (char c : numStr.toCharArray()) {
				if ((c - '0') == 3 || (c - '0') == 6 || (c - '0') == 9) {
					sb.append("-");
					flag = false;
				}
			}

			if (flag)
				sb.append(i).append(" ");
			else
				sb.append(" ");

		}

		System.out.println(sb);

	}

}