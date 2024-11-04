import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] chess = { 1, 1, 2, 2, 2, 8 };

		for (int i = 0; i < chess.length; i++) {
			int number = Integer.parseInt(st.nextToken());

			chess[i] -= number;
		}

		for (int i = 0; i < chess.length; i++) {
			sb.append(chess[i]).append(" ");
		}

		System.out.println(sb.toString().trim());

	}

}