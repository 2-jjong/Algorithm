import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] arr = new boolean[31];

		for (int i = 0; i < 28; i++) {
			int number = Integer.parseInt(br.readLine());

			arr[number] = true;
		}

		for (int i = 1; i < 31; i++) {
			if (!arr[i])
				sb.append(i).append("\n");
		}

		System.out.println(sb.toString().trim());

	}

}