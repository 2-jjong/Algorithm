import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		int baseNumber = Integer.parseInt(st.nextToken());
		int result = toDecimal(input, baseNumber);
		System.out.println(result);
	}

	public static int toDecimal(String input, int baseNumber) {
		int decimal = 0;
		int length = input.length();

		for (int i = 0; i < length; i++) {
			char ch = input.charAt(i);

			int value;

			if (ch >= '0' && ch <= '9') {
				value = ch - '0';
			} else {
				value = ch - 'A' + 10;
			}

			decimal += value * Math.pow(baseNumber, length - i - 1);
		}

		return decimal;
	}
}