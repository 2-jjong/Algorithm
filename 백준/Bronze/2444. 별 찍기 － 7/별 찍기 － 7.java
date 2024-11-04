import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n - i; j++) {
				sb.append(" ");
			}

			for (int j = 0; j < 2 * i - 1; j++) {
				sb.append("*");
			}

			if (i != n) {
				sb.append("\n");
			}
		}

		for (int i = n - 1; i >= 1; i--) {
			sb.append("\n");

			for (int j = 0; j < n - i; j++) {
				sb.append(" ");
			}

			for (int j = 0; j < 2 * i - 1; j++) {
				sb.append("*");
			}
		}

		System.out.print(sb.toString());
	}
}
