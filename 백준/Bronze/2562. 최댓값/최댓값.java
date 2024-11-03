import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int max = Integer.parseInt(br.readLine());
		int index = 1;

		for (int i = 1; i < 9; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num > max) {
				max = num;
				index = i + 1;
			}

		}

		sb.append(max).append("\n").append(index);

		System.out.println(sb.toString().trim());

	}

}