import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int k = 0; k < t; k++) {
			int n = Integer.parseInt(br.readLine());
			int answer = 0;

			for (int i = 1; i <= n; i++) {
				if (i % 2 == 0)
					answer -= i;
				else
					answer += i;
			}

			sb.append("#").append(k + 1).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);

	}

}