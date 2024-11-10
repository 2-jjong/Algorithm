import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());

		sb.append(num1 + num2).append("\n");
		sb.append(num1 - num2).append("\n");
		sb.append(num1 * num2).append("\n");
		sb.append(num1 / num2).append("\n");

		System.out.println(sb);

	}

}