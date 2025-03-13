import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static List<Integer>[] graph;
	private static int[] edgeList;
	private static StringBuilder sb = new StringBuilder();

	public static void topologySort() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (edgeList[i] == 0)
				q.add(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			sb.append(cur).append(" ");

			for (int next : graph[cur]) {
				edgeList[next]--;

				if (edgeList[next] == 0) {
					q.add(next);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		edgeList = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from].add(to);
			edgeList[to]++;
		}

		topologySort();

		System.out.println(sb);
	}
}