import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double num1 = Integer.parseInt(st.nextToken());
		double num2 = Integer.parseInt(st.nextToken());

		System.out.println(num1 / num2);
	}

}