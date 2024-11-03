import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		Set<Integer> c = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(st.nextToken());
			a.add(number);
			c.add(number);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int number = Integer.parseInt(st.nextToken());
			b.add(number);

			if (a.contains(number))
				c.remove(number);
			else
				c.add(number);
		}

		System.out.println(c.size());

	}

}