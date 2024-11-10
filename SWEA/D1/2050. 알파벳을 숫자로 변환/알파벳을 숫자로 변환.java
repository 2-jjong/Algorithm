import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		for (char c : str.toCharArray()) {
			sb.append(c - 'A' + 1).append(" ");
		}

		System.out.println(sb.toString().trim());

	}

}