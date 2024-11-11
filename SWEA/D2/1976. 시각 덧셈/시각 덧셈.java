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
			int hour = Integer.parseInt(st.nextToken());
			int minnute = Integer.parseInt(st.nextToken());
			int plusHour = Integer.parseInt(st.nextToken());
			int plusMinuute = Integer.parseInt(st.nextToken());

			minnute += plusMinuute;

			if (minnute >= 60) {
				plusHour++;
				minnute -= 60;
			}

			hour += plusHour;

			if (hour > 12)
				hour -= 12;

			sb.append("#").append(testCase + 1).append(" ").append(hour).append(" ").append(minnute).append("\n");
		}

		System.out.println(sb);

	}

}