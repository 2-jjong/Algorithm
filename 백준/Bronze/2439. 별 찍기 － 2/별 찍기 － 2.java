import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (j <= i)
					sb.append("*");
				else
					sb.append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

}