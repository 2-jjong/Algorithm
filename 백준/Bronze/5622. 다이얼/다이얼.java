import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] number = "0 1 ABC DEF GHI JKL MNO PQRS TUV WXYZ".split(" ");
		int sum = 0;

		for (char c : str.toCharArray()) {
			for (int i = 0; i < number.length; i++) {
				if (number[i].contains(String.valueOf(c))) {
					sum += i + 1;
					break;
				}
			}
		}

		System.out.println(sum);
	}

}