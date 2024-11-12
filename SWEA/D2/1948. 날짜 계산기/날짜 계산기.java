import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			int firstMonth = Integer.parseInt(st.nextToken());
			int firstDay = Integer.parseInt(st.nextToken());
			int secondMonth = Integer.parseInt(st.nextToken());
			int secondDay = Integer.parseInt(st.nextToken());
			int answer = 0;

			for (int i = firstMonth; i < secondMonth; i++) {
				answer += month[i];
			}
			answer = answer - firstDay + 1;
			answer += secondDay;

			sb.append("#").append(testCase + 1).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

}