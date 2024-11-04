import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			sb.append(str.substring(0, 1)).append(str.substring(str.length()-1, str.length())).append("\n");
		}

		System.out.println(sb);

	}

}