import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		int sum = 0;

		for (char c : number.toCharArray()) {
			sum += c - '0';
		}

		System.out.println(sum);

	}

}