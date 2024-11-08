import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<Integer> prime = sieveOfEratosthenes(n);

		if (n == 1)
			return;

		int index = 0;
		while (n > 1) {
			int number = prime.get(index);

			if (n % number == 0) {
				n /= number;
				sb.append(number).append("\n");
				index = 0;
			} else {
				index++;
			}
		}

		System.out.println(sb);

	}

	public static List<Integer> sieveOfEratosthenes(int n) {
		boolean[] isPrime = new boolean[n + 1];
		List<Integer> prime = new ArrayList<>();
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

		for (int i = 2; i <= n; i++) {
			if (isPrime[i])
				prime.add(i);
		}

		return prime;
	}

}