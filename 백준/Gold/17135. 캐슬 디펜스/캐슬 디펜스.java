import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, D;
	private static int[][] grid;
	private static int[] archers = new int[3];
	private static int maxKill = 0;

	public static int simulate() {
		int[][] tempGrid = new int[N][M];
		for (int i = 0; i < N; i++) {
			tempGrid[i] = grid[i].clone();
		}

		int killCount = 0;
		for (int turn = 0; turn < N; turn++) {
			boolean[][] enemySelected = new boolean[N][M];

			// 각 궁수마다 적 찾기
			for (int archer : archers) {
				int[] enemy = findEnemy(tempGrid, archer);
				if (enemy != null) {
					int x = enemy[0], y = enemy[1];
					enemySelected[x][y] = true;
				}
			}

			// 찾은 적 한번에 제거
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (enemySelected[i][j] && tempGrid[i][j] == 1) {
						tempGrid[i][j] = 0;
						killCount++;
					}
				}
			}

			// 적 이동
			for (int i = N - 1; i > 0; i--) {
				tempGrid[i] = tempGrid[i - 1].clone();
			}
			for (int j = 0; j < M; j++) {
				tempGrid[0][j] = 0;
			}
		}

		return killCount;
	}

	public static int[] findEnemy(int[][] tempGrid, int archerCol) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			int distanceA = Math.abs(N - a[0]) + Math.abs(archerCol - a[1]);
			int distanceB = Math.abs(N - b[0]) + Math.abs(archerCol - b[1]);

			if (distanceA != distanceB) {
				return Integer.compare(distanceA, distanceB);
			}

			return Integer.compare(a[1], b[1]);
		});

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (tempGrid[x][y] == 1) {
					int distance = Math.abs(N - x) + Math.abs(archerCol - y);

					if (distance <= D) {
						pq.offer(new int[] { x, y });
					}
				}
			}
		}

		if (pq.isEmpty()) {
			return null;
		}

		return pq.poll();
	}

	public static void subSet(int start, int count) {
		if (count == 3) {
			maxKill = Math.max(maxKill, simulate());
			return;
		}

		for (int i = start; i < M; i++) {
			archers[count] = i;
			subSet(i + 1, count + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		grid = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());

			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		subSet(0, 0);

		System.out.println(maxKill);
	}
}