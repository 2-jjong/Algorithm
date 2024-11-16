import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			List<Integer> password = new ArrayList<>();

			for (char c : str.toCharArray()) {
				password.add(c - '0');
			}

			int index = 0;

			while (index < password.size() - 1) {
				if (password.get(index) == password.get(index + 1)) {
					password.remove(index);
					password.remove(index);
					index = Math.max(0, index - 1);
				} else {
					index++;
				}
			}

			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < password.size(); i++) {
				sb.append(password.get(i));
			}
			sb.append("\n");

		}

		System.out.println(sb);

	}

}