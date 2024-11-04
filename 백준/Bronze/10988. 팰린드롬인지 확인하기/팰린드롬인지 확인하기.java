import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int result = 1;

		for (int i = 0; i < str.length() / 2; i++) {
			String first = str.substring(i, i + 1);
			String last = str.substring(str.length() - i - 1, str.length() - i);

			if (!first.equals(last)) {
				result = 0;
				break;
			}
		}

		System.out.print(result);

	}
}
