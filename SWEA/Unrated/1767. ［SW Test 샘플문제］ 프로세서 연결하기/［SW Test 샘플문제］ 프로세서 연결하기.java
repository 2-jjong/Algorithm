import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static int[][] grid;
	private static List<Core> coreList;
	private static int coreCount, maxCore, minWire;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	static class Core {
		int x;
		int y;

		Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void calcCore(int index, int connectedCore, int wireLength) {
		if (index == coreCount) {
			if (connectedCore > maxCore) {
				maxCore = connectedCore;
				minWire = wireLength;
			} else if (connectedCore == maxCore) {
				minWire = Math.min(minWire, wireLength);
			}

			return;
		}

		Core core = coreList.get(index);

		for (int dir = 0; dir < 4; dir++) {
			if (canConnect(core.x, core.y, dir)) {
				int wires = connect(core.x, core.y, dir, 2);
				calcCore(index + 1, connectedCore + 1, wireLength + wires);
				connect(core.x, core.y, dir, 0);
			}
		}

		calcCore(index + 1, connectedCore, wireLength);
	}

	private static boolean canConnect(int x, int y, int dir) {
		int nx = x, ny = y;

		while (true) {
			nx += dx[dir];
			ny += dy[dir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				return true;

			if (grid[nx][ny] != 0)
				return false;
		}
	}

	private static int connect(int x, int y, int dir, int status) {
		int nx = x, ny = y;
		int count = 0;

		while (true) {
			nx += dx[dir];
			ny += dy[dir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				break;

			grid[nx][ny] = status;
			count++;
		}

		return count;
	}

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			/**
			 * 1. 입력 파일 객체화
			 */

			N = Integer.parseInt(br.readLine());
			grid = new int[N][N];
			maxCore = 0;
			minWire = Integer.MAX_VALUE;
			coreList = new ArrayList<>();

			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());

					if (grid[i][j] == 1 && (i != 0 && j != 0 && i + 1 != N && j + 1 != N)) {
						coreList.add(new Core(i, j));
					}
				}
			}

			coreCount = coreList.size();

			/**
			 * 2. 알고리즘 풀기
			 */

			coreCount = coreList.size();

			calcCore(0, 0, 0);

			/**
			 * 3. 정답 출력
			 */

			int answer = minWire;

			sb.append(answer).append("\n");

		}
		System.out.println(sb);
	}
}