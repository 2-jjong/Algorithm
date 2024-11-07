import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == -1)
				break;

			List<Integer> divisor = new ArrayList<>();
			int sum = 0;

			for (int i = 1; i <= n / 2; i++) {
				if (n % i == 0) {
					sum += i;
					divisor.add(i);
				}
			}

			if (n == sum) {
				sb.append(n).append(" = ");
				for (int i = 0; i < divisor.size(); i++) {
					sb.append(divisor.get(i));

					if (i < divisor.size() - 1)
						sb.append(" + ");
				}
				sb.append("\n");
			} else {
				sb.append(n).append(" is NOT perfect.").append("\n");
			}

		}

		System.out.println(sb);

	}

}