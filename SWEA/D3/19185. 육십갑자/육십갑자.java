import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < tc; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			String[] s = new String[n];
			String[] t = new String[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				s[i] = st.nextToken();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				t[i] = st.nextToken();
			}

			int q = Integer.parseInt(br.readLine());

			sb.append("#").append(testCase + 1).append(" ");
			for (int i = 0; i < q; i++) {
				int y = Integer.parseInt(br.readLine());
				int sIndex = (int) ((y - 1) % n);
				int tIndex = (int) ((y - 1) % m);
				sb.append(s[sIndex]).append(t[tIndex]).append(" ");
			}
			sb.append("\n");

		}

		System.out.println(sb);

	}

}