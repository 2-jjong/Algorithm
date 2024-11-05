import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int range = 1;
		int i = 1;

		if (n == 1) {
			System.out.println(n);
			return;
		}

		while (true) {
			range += 6 * i++;

			if (n <= range) {
				System.out.println(i);
				break;
			}
		}

	}

}