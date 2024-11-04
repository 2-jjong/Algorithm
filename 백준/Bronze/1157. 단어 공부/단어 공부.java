import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] alphabet = new int[26];
		Arrays.fill(alphabet, 0);

		for (char c : str.toCharArray()) {
			int number = c >= 97 ? c - 'a' : c - 'A';

			alphabet[number]++;
		}

		int max = 0;
		char result = '?';

		for (int i = 0; i < alphabet.length; i++) {
			if (max < alphabet[i]) {
				max = alphabet[i];
				result = (char) (i + 'A');
			} else if (max == alphabet[i]) {
				result = '?';
			}
		}

		System.out.println(result);

	}
}
