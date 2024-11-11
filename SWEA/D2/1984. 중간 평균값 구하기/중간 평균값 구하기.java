import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int k = 0; k < t; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int sum = num;
			int max = num;
			int min = num;

			for (int i = 1; i < 10; i++) {
				int temp = Integer.parseInt(st.nextToken());

				if (temp > max)
					max = temp;

				if (temp < min)
					min = temp;

				sum += temp;
			}

			sum = sum - min - max;

			int answer = (int) Math.round(sum / 8.0);

			sb.append("#").append(k + 1).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);

	}

}