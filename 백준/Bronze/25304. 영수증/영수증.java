import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int sum = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int price = Integer.parseInt(st.nextToken());
			int quantity = Integer.parseInt(st.nextToken());

			sum += price * quantity;
		}

		if (x == sum)
			sb.append("Yes");
		else
			sb.append("No");

		System.out.println(sb);

	}

}