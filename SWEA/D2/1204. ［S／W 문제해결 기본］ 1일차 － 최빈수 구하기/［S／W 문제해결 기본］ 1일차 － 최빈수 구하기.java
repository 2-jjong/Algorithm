import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			Map<Integer, Integer> map = new HashMap<>();

			while (st.hasMoreTokens()) {
				int number = Integer.parseInt(st.nextToken());
				map.put(number, map.getOrDefault(number, 0) + 1);
			}

			int answer = 0;
			int freq = 0;

			for (int key : map.keySet()) {
				int currentFreq = map.get(key);

				if (freq < currentFreq || (freq == currentFreq && answer < key)) {
					freq = currentFreq;
					answer = key;
				}

			}

			sb.append("#").append(testCase + 1).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

}