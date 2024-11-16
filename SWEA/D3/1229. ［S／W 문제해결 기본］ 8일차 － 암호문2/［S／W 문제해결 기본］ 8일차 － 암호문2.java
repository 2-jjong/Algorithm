import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());
			List<String> str = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				str.add(st.nextToken());
			}

			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < m; i++) {
				String command = st.nextToken();
				if (command.equals("I")) {
					int index = Integer.parseInt(st.nextToken());
					int k = Integer.parseInt(st.nextToken());

					for (int j = 0; j < k; j++) {
						str.add(index++, st.nextToken());
					}
				} else if (command.endsWith("D")) {
					int index = Integer.parseInt(st.nextToken());
					int k = Integer.parseInt(st.nextToken());

					for (int j = 0; j < k; j++) {
						str.remove(index);
					}
				}
			}

			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(str.get(i)).append(" ");
			}
			sb.append("\n");

		}

		System.out.println(sb);

	}

}