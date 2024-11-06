import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Coordinate[] coordinates = new Coordinate[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			coordinates[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(coordinates, (o1, o2) -> {
			if (o1.y == o2.y)
				return o1.x - o2.x;

			return o1.y - o2.y;
		});

		for (int i = 0; i < n; i++) {
			sb.append(coordinates[i].toString()).append("\n");
		}

		System.out.println(sb);

	}

	public static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return x + " " + y;
		}

	}

}