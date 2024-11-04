import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int[] alphabet = new int[26];
		Arrays.fill(alphabet, -1);

		for (char c : str.toCharArray()) {
			int number = c - 'a';
			if (alphabet[number] == -1) {
				alphabet[number] = str.indexOf(c);
			}
		}

		for (int i = 0; i < alphabet.length; i++) {
			sb.append(alphabet[i]).append(" ");
		}

		System.out.println(sb.toString().trim());

	}

}