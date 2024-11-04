import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int max = 0;
		int row = 1, column = 1;

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int number = Integer.parseInt(st.nextToken());
				if (max < number) {
					max = number;
					row = i + 1;
					column = j + 1;
				}
			}
		}

		sb.append(max).append("\n").append(row).append(" ").append(column);

		System.out.println(sb);

	}

}