import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int state = 2;

		for (int i = 0; i < n; i++) {
			state = state * 2 - 1;
		}

		int result = (int) Math.pow(state, 2);

		System.out.println(result);

	}

}