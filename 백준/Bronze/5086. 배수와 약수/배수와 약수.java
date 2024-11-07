import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int number1 = Integer.parseInt(st.nextToken());
			int number2 = Integer.parseInt(st.nextToken());

			if (number1 == 0 && number2 == 0)
				break;

			if (number1 % number2 == 0) {
				sb.append("multiple").append("\n");

			} else if (number2 % number1 == 0) {
				sb.append("factor").append("\n");

			} else {
				sb.append("neither").append("\n");
			}
		}

		System.out.println(sb);

	}

}