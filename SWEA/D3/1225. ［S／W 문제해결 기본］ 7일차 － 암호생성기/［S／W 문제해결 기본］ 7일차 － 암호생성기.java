import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			br.readLine();
			int[] arr = new int[8];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int minus = 1;

			while (arr[7] > 0) {
				arr[0] -= minus;

				int temp = arr[0];
				for (int i = 1; i < 8; i++) {
					arr[i - 1] = arr[i];
				}
				arr[7] = Math.max(temp, 0);

				minus = (minus % 5) + 1;
			}

			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < 8; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");

		}

		System.out.println(sb);

	}

}