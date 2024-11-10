import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;

			for (int j = 0; j < 10; j++) {
				int number = Integer.parseInt(st.nextToken());

				if (number % 2 == 1)
					sum += number;
			}

			sb.append("#").append(i + 1).append(" ").append(sum).append("\n");
		}

		System.out.println(sb);

	}

}