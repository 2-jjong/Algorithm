import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int N, K, answer;
	private static boolean[] visited;

	public static void simulate(int value) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { value, 0 });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentValue = current[0];
			int currentDepth = current[1];

			if (currentValue == K) {
				answer = currentDepth;
				return;
			}

			int[] nextValues = { currentValue - 1, currentValue + 1, currentValue * 2 };

			for (int nextValue : nextValues) {
				if (nextValue >= 0 && nextValue <= 100000 && !visited[nextValue]) {
					queue.add(new int[] { nextValue, currentDepth + 1 });
					visited[nextValue] = true;
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		K = Integer.parseInt(split[1]);
		visited = new boolean[100001];

		simulate(N);

		System.out.println(answer);
	}
}