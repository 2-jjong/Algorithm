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
			int sum = 0;

			for (int j = 0; j < 10; j++) {
				sum += Integer.parseInt(st.nextToken());
			}

			int avg = (int) Math.round(sum / 10.0);
			sb.append("#").append(i + 1).append(" ").append(avg).append("\n");
		}

		System.out.println(sb);

	}

}