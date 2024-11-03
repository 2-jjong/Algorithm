import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int arrIndex1 = Integer.parseInt(st.nextToken());
			int arrIndex2 = Integer.parseInt(st.nextToken());
			int ballNumber = Integer.parseInt(st.nextToken());

			for (int j = arrIndex1; j <= arrIndex2; j++) {
				arr[j] = ballNumber;
			}

		}

		for (int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb.toString().trim());

	}

}