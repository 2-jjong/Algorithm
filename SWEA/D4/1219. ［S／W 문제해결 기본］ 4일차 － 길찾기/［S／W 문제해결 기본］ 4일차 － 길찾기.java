import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	// DFS
	public static void dfs(int node, List<Integer>[] graph, boolean[] visited) {

		// 현재 노드 방문 처리 및 출력
		visited[node] = true;

		// 인접 노드들 방문 (재귀 호출)
		for (int neighbor : graph[node]) {
			if (!visited[neighbor]) { // 이미 방문한 노드는 탐색 안 함
				dfs(neighbor, graph, visited);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		/**
		 * 0. 입력파일 읽어들이기
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#" + testCase + " ");

			// 알고리즘 코드 작성하기
			/**
			 * 1. 입력 파일 객체화
			 */

			int n = 100; // 노드 개수 (0번부터 99번 노드 사용)
			List<Integer>[] graph = new ArrayList[n];

			// 인접 리스트 초기화
			for (int i = 0; i < n; i++) {
				graph[i] = new ArrayList<>();
			}

			// 그래프 간선 추가
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine());

			while (st.hasMoreTokens()) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				graph[start].add(end);
			}

			// 방문 여부 추적 배열
			boolean[] visited = new boolean[n];

			/**
			 * 2. 알고리즘 풀기
			 */

			// DFS 탐색 시작
			dfs(0, graph, visited);

			/**
			 * 3. 정답 출력
			 */
			int answer = visited[99] ? 1 : 0;

			sb.append(answer).append("\n");

		}

		System.out.println(sb);
	}
}