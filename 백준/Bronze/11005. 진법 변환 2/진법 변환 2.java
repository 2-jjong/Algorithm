import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		System.out.println(convertToBase(N, B));
	}

	public static String convertToBase(int number, int base) {
		StringBuilder result = new StringBuilder();

		if (number == 0) {
			return "0";
		}

		while (number > 0) {
			int remainder = number % base;
			if (remainder < 10) {
				result.append((char) (remainder + '0'));
			} else {
				result.append((char) (remainder - 10 + 'A'));
			}
			number /= base;
		}

		return result.reverse().toString();
	}
}