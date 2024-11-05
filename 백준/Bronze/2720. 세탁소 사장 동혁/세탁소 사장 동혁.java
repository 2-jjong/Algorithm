import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int cent = Integer.parseInt(br.readLine());

			int quarter = cent / 25;
			cent %= 25;

			int dime = cent / 10;
			cent %= 10;

			int nickel = cent / 5;
			cent %= 5;

			int penny = cent;

			sb.append(quarter).append(" ").append(dime).append(" ").append(nickel).append(" ").append(penny)
					.append("\n");
		}

		System.out.println(sb);

	}

}