import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\test_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());
			String find = br.readLine();
			String str = br.readLine();
			int index = 0;
			int count = 0;

			while ((index = str.indexOf(find, index)) != -1) {
				count++;
				index += find.length();
			}

			sb.append("#").append(testCase).append(" ").append(count).append("\n");
		}

		System.out.print(sb);
	}

}