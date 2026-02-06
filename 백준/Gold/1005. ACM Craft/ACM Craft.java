import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] buildTime = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            // 인접 리스트 및 진입차수 초기화
            List<Integer>[] adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }
            int[] inDegree = new int[N + 1];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                adj[v1].add(v2);
                inDegree[v2]++;
            }

            int target = Integer.parseInt(br.readLine());

            int result = getMinBuildTime(N, buildTime, adj, inDegree, target);
            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
    }

    // 위상 정렬과 DP를 이용해 건설 완료 시간 계산
    static int getMinBuildTime(int N, int[] buildTime, List<Integer>[] adj, int[] inDegree, int target) {
        Queue<Integer> q = new LinkedList<>();
        int[] resultTime = new int[N + 1];

        // 진입차수 0 건물부터 시작
        for (int i = 1; i <= N; i++) {
            resultTime[i] = buildTime[i];
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // 위상 정렬 수행
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : adj[cur]) {
                // 가장 늦게 끝나는 시간을 선택
                resultTime[next] = Math.max(resultTime[next], resultTime[cur] + buildTime[next]);
                inDegree[next]--;

                // 선행 조건이 모두 만족되면 큐에 추가
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return resultTime[target];
    }
}