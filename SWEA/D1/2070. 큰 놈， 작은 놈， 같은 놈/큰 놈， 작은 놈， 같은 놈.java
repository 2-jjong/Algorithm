import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			if (num1 == num2)
				sb.append("#").append(i + 1).append(" =").append("\n");
			else if (num1 < num2)
				sb.append("#").append(i + 1).append(" <").append("\n");
			else
				sb.append("#").append(i + 1).append(" >").append("\n");
		}

		System.out.println(sb);

	}

}