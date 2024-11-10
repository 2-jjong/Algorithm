import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Set<Integer> set = new TreeSet<>();
		
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				set.add(i);
				set.add(n / i);
			}
		}

		for (int num : set) {
			sb.append(num).append(" ");
		}

		System.out.println(sb.toString().trim());
	}

}