import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (isPrime(num))
				answer++;
		}

		System.out.println(answer);

	}

	public static boolean isPrime(int num) {
		if (num == 1)
			return false;

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0)
				return false;
		}

		return true;
	}

}