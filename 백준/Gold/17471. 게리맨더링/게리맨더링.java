import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] population;
	static List<Integer>[] graph;
	static int minDifference = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		population = new int[N + 1];
		graph = new ArrayList[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());

			for (int j = 0; j < count; j++) {
				int next = Integer.parseInt(st.nextToken());
				graph[i].add(next);
			}
		}

		for (int i = 1; i <= N / 2; i++) {
			boolean[] selected = new boolean[N + 1];
			generateCombinations(1, 0, i, selected);
		}

		System.out.println(minDifference == Integer.MAX_VALUE ? -1 : minDifference);
	}

	static void generateCombinations(int index, int count, int target, boolean[] selected) {
		if (count == target) {
			checkDivision(selected);
			return;
		}

		if (index > N)
			return;

		selected[index] = true;
		generateCombinations(index + 1, count + 1, target, selected);

		selected[index] = false;
		generateCombinations(index + 1, count, target, selected);
	}

	static void checkDivision(boolean[] selected) {
		List<Integer> groupA = new ArrayList<>();
		List<Integer> groupB = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			if (selected[i])
				groupA.add(i);
			else
				groupB.add(i);
		}

		if (groupA.isEmpty() || groupB.isEmpty())
			return;

		if (bfs(groupA) && bfs(groupB)) {
			int populationA = calculatePopulation(groupA);
			int populationB = calculatePopulation(groupB);
			minDifference = Math.min(minDifference, Math.abs(populationA - populationB));
		}
	}

	static boolean bfs(List<Integer> group) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();

		queue.add(group.get(0));
		visited[group.get(0)] = true;

		int visitedCount = 0;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			visitedCount++;

			for (int neighbor : graph[current]) {
				if (!visited[neighbor] && group.contains(neighbor)) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}

		return visitedCount == group.size();
	}

	static int calculatePopulation(List<Integer> group) {
		int sum = 0;

		for (int node : group) {
			sum += population[node];
		}

		return sum;
	}
}