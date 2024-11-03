import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr[0] = Integer.parseInt(st.nextToken());
		int min = arr[0], max = arr[0];

		for (int i = 1; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (arr[i] < min)
				min = arr[i];

			if (arr[i] > max)
				max = arr[i];
		}

		sb.append(min).append(" ").append(max);

		System.out.println(sb.toString().trim());

	}

}