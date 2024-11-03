import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = "";

		while ((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			sb.append(num1 + num2).append("\n");

		}

		System.out.println(sb);

	}

}