import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[42];

		for (int i = 0; i < 10; i++) {
			int number = Integer.parseInt(br.readLine());

			arr[number % 42]++;
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				sum++;
		}

		System.out.println(sum);

	}

}