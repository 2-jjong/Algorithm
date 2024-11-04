import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = n;

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			Set<Character> set = new HashSet<>();

			set.add(str.charAt(0));

			for (int j = 1; j < str.length(); j++) {
				char currentChar = str.charAt(j);

				if (currentChar != str.charAt(j - 1)) {
					if (set.contains(currentChar)) {
						result--;
						break;
					} else {
						set.add(currentChar);
					}
				}
			}
		}

		System.out.println(result);

	}

}