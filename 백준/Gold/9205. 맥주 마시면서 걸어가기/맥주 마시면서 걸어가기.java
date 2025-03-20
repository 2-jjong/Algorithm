import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static Point start;
	private static Point end;
	private static List<Point> cvs;
	private static Set<String> visited;
	private static boolean result;

	static class Point {
		int row;
		int col;
		int dist;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
			this.dist = 0;
		}

		public Point(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}

	public static void solve() {
		Queue<Point> q = new LinkedList<>();

		q.add(start);

		while (!q.isEmpty()) {
			Point cur = q.poll();

			int distDiff = Math.abs(cur.row - end.row) + Math.abs(cur.col - end.col);

			if (cur.dist - distDiff >= 0) {
				result = true;
				return;
			}

			for (int i = 0; i < cvs.size(); i++) {
				Point curCvs = cvs.get(i);
				distDiff = Math.abs(cur.row - curCvs.row) + Math.abs(cur.col - curCvs.col);

				if (cur.dist - distDiff >= 0) {
					String visitStr = curCvs.row + ", " + curCvs.col + ", " + curCvs.dist;

					if (!visited.contains(visitStr)) {
						visited.add(visitStr);
						q.add(new Point(curCvs.row, curCvs.col, 1000));
					}
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			cvs = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1000);

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				cvs.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			st = new StringTokenizer(br.readLine());
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			visited = new HashSet<>();
			result = false;
			solve();

			sb.append(result ? "happy" : "sad").append("\n");
		}

		System.out.println(sb);
	}
}
