import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (arr[i] > max) {
				max = arr[i];
			}
		}

		double sum = 0;

		for (int i = 0; i < n; i++) {
			sum += (double) arr[i] / max * 100;
		}

		double avg = sum / n;

		System.out.println(avg);

	}

}