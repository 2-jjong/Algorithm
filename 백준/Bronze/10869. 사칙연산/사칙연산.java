import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());

		sb.append(num1 + num2).append("\n");
		sb.append(num1 - num2).append("\n");
		sb.append(num1 * num2).append("\n");
		sb.append(num1 / num2).append("\n");
		sb.append(num1 % num2);

		System.out.println(sb);
	}

}