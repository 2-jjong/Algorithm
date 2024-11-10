import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String num = br.readLine();
			int month = Integer.parseInt(num.substring(4, 6));
			int day = Integer.parseInt(num.substring(6, 8));

			if (((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
					&& day <= 31) || ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30)
					|| (month == 2 && day <= 28))
				sb.append("#").append(i + 1).append(" ")
						.append(num.substring(0, 4) + "/" + num.substring(4, 6) + "/" + num.substring(6, 8))
						.append("\n");
			else
				sb.append("#").append(i + 1).append(" ").append(-1).append("\n");

		}

		System.out.println(sb);

	}

}