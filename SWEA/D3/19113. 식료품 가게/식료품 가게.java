import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= t; testCase++) {
			int n = Integer.parseInt(br.readLine());
			long[] prices = new long[2 * n];
			List<Long> discountPrices = new ArrayList<>();
			boolean[] checked = new boolean[2 * n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 2 * n; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 2 * n - 1; i >= 0; i--) {
				if (checked[i])
					continue;
				long price = prices[i];
				long discountPrice = (int) (price * 0.75);

				for (int j = i - 1; j >= 0; j--) {
					if (prices[j] == discountPrice && !checked[j]) {
						checked[j] = true;
						discountPrices.add(discountPrice);
						break;
					}
				}
				checked[i] = true;
			}

			Collections.sort(discountPrices);

			sb.append("#").append(testCase).append(" ");
			for (long discount : discountPrices) {
				sb.append(discount).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}