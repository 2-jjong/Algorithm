import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[2];

		for (int i = 0; i < 2; i++) {
			StringBuilder sb = new StringBuilder(st.nextToken());
			String reverseStr = sb.reverse().toString();

			num[i] = Integer.parseInt(reverseStr);
		}

		if (num[0] > num[1])
			System.out.println(num[0]);
		else
			System.out.println(num[1]);

	}

}