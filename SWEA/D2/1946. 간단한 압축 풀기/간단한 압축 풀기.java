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
			String answer;
			int length = 0;

			sb.append("#").append(testCase + 1).append("\n");
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String alphabet = st.nextToken();
				int iter = Integer.parseInt(st.nextToken());

				for (int j = 0; j < iter; j++) {
					sb.append(alphabet);
					length++;
					
					if(length==10) {
						sb.append("\n");
						length=0;
					}
				}
			}

			sb.append("\n");

		}

		System.out.println(sb);

	}

}