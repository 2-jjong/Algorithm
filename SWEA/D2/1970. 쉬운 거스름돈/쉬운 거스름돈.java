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
			int temp;

			sb.append("#").append(testCase + 1).append("\n");

			temp = n / 50000;
			sb.append(temp).append(" ");
			n %= 50000;

			temp = n / 10000;
			sb.append(temp).append(" ");
			n %= 10000;

			temp = n / 5000;
			sb.append(temp).append(" ");
			n %= 5000;

			temp = n / 1000;
			sb.append(temp).append(" ");
			n %= 1000;

			temp = n / 500;
			sb.append(temp).append(" ");
			n %= 500;

			temp = n / 100;
			sb.append(temp).append(" ");
			n %= 100;

			temp = n / 50;
			sb.append(temp).append(" ");
			n %= 50;

			temp = n / 10;
			sb.append(temp).append("\n");

		}

		System.out.println(sb);

	}

}