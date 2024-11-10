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
			int max = Integer.parseInt(st.nextToken());

			for (int j = 1; j < 10; j++) {
				int number = Integer.parseInt(st.nextToken());

				if (max < number)
					max = number;
			}

			sb.append("#").append(i + 1).append(" ").append(max).append("\n");
		}

		System.out.println(sb);

	}

}