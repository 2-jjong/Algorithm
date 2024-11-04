import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int sum = 0;

		for (char c : str.toCharArray()) {
			sum += c - '0';
		}

		System.out.println(sum);

	}

}