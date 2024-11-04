import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[][] matrix = new String[5][15];

		for (int i = 0; i < 5; i++) {
			Arrays.fill(matrix[i], " ");
		}

		for (int i = 0; i < 5; i++) {
			String str = br.readLine();

			for (int j = 0; j < str.length(); j++) {
				matrix[i][j] = str.substring(j, j + 1);
			}
		}

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (!matrix[j][i].equals(" ")) {
					sb.append(matrix[j][i]);
				}
			}
		}

		System.out.println(sb);
	}
}