import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String num1 = br.readLine();
		String num2 = br.readLine();
		char[] charNum2 = num2.toCharArray();
		int[] resultNum = new int[3];

		for (int i = 0; i < 3; i++) {
			resultNum[i] = Integer.parseInt(num1) * (charNum2[i] - '0');
		}

		sb.append(resultNum[2]).append("\n");
		sb.append(resultNum[1]).append("\n");
		sb.append(resultNum[0]).append("\n");
		resultNum[0] *= 100;
		resultNum[1] *= 10;
		sb.append(resultNum[0] + resultNum[1] + resultNum[2]);

		System.out.println(sb);
	}

}