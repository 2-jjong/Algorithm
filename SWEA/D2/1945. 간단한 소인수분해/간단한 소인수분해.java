import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[] prime = { 2, 3, 5, 7, 11 };
			int[] primeCount = new int[5];
			int index = 0;

			while (n > 1) {
				if (n % prime[index] == 0) {
					primeCount[index]++;
					n /= prime[index];
				} else {
					index++;
				}

			}

			sb.append("#").append(testCase + 1).append(" ");
			for (int i = 0; i < 5; i++) {
				sb.append(primeCount[i]);

				if (i < 5)
					sb.append(" ");
			}
			sb.append("\n");

		}

		System.out.println(sb);

	}

}