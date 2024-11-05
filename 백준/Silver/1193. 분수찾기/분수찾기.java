import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int range = 0;
		int i = 1;

		while (true) {
			range += i;

			if (n <= range) {
				int seq = n - range + i;

				if (i % 2 == 0) {
					sb.append(seq).append("/").append(i + 1 - seq);
				} else {
					sb.append(i + 1 - seq).append("/").append(seq);
				}
				break;
			}

			i++;
		}

		System.out.println(sb);

	}

}