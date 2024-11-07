import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		boolean[] isPrime = sieveOfEratosthenes(n);
		int sum = 0;
		int min = -1;

		for (int i = m; i <= n; i++) {
			if (isPrime[i])
				sum += i;

			if (min == -1 && isPrime[i])
				min = i;

		}

		if (min == -1) {
			System.out.println(min);
			return;
		}

		System.out.println(sum + "\n" + min);

	}

	public static boolean[] sieveOfEratosthenes(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		return isPrime;
	}

}