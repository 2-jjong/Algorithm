import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] original = new int[n];
		int[] sorted = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			original[i] = Integer.parseInt(st.nextToken());
			sorted[i] = original[i];
		}

		Arrays.sort(sorted);

		Map<Integer, Integer> coordinateMap = new HashMap<>();
		int index = 0;
		for (int x : sorted) {
			if (!coordinateMap.containsKey(x)) {
				coordinateMap.put(x, index++);
			}
		}

		for (int i = 0; i < n; i++) {
			sb.append(coordinateMap.get(original[i])).append(" ");
		}

		System.out.println(sb.toString().trim());

	}

}