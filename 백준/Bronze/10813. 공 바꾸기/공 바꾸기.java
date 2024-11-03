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

		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int arrIndex1 = Integer.parseInt(st.nextToken());
			int arrIndex2 = Integer.parseInt(st.nextToken());
			int temp;

			temp = arr[arrIndex1];
			arr[arrIndex1] = arr[arrIndex2];
			arr[arrIndex2] = temp;
		}

		for (int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb.toString().trim());

	}

}