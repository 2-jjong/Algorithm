import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\GNS_test_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= t; testCase++) {
			String[] numStr = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
			Map<String, Integer> map = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];

			map.put("ZRO", 0);
			map.put("ONE", 1);
			map.put("TWO", 2);
			map.put("THR", 3);
			map.put("FOR", 4);
			map.put("FIV", 5);
			map.put("SIX", 6);
			map.put("SVN", 7);
			map.put("EGT", 8);
			map.put("NIN", 9);

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = map.get(st.nextToken());
			}
			Arrays.sort(arr);

			sb.append("#").append(testCase).append("\n");
			for (int i = 0; i < n; i++) {
				sb.append(numStr[arr[i]]).append(" ");
			}

			sb.append("\n");

		}

		System.out.println(sb);

	}

}