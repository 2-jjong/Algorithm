import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int iterNumber = Integer.parseInt(st.nextToken());
			String str = st.nextToken();

			for (char c : str.toCharArray()) {
				for (int j = 0; j < iterNumber; j++) {
					sb.append(c);
				}
			}

			sb.append("\n");

		}

		System.out.println(sb.toString().trim());

	}

}