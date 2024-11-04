import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String str = br.readLine();
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {

			for (String cro : croatia) {
				int len = cro.length();

				if (i + len <= str.length() && str.substring(i, i + len).equals(cro)) {
					i += len - 1;
					break;
				}
			}

			sum++;
		}

		System.out.println(sum);

	}

}