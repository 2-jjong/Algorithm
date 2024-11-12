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
			int answer = 0;
			int speed = 0;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());

				if (command == 1) {
					speed += Integer.parseInt(st.nextToken());
				} else if (command == 2) {
					speed -= Integer.parseInt(st.nextToken());

					if (speed < 0)
						speed = 0;
				}

				answer += speed;

			}

			sb.append("#").append(testCase + 1).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

}