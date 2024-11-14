import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int answer = 0;

			for (int i = 2; i < n - 2; i++) {
				int currentMax = Integer.MIN_VALUE;
				int currentHeight = arr[i];

				for (int j = i - 2; j <= i + 2; j++) {
					if (j == i)
						continue;

					currentMax = Math.max(currentMax, arr[j]);
				}

				if (currentMax < currentHeight)
					answer += currentHeight - currentMax;

			}

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}

		System.out.print(sb);
	}
}