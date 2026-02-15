import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 문제의 개수
        int M = Integer.parseInt(st.nextToken()); // 정보의 개수

        int[] indegree = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            
            graph.get(first).add(second); // first 다음에 second를 풀어야 함
            indegree[second]++; // second의 진입 차수 증가
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 진입 차수가 0인 문제를 모두 PQ에 삽입
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        // 위상 정렬
        while (!pq.isEmpty()) {
            int current = pq.poll();
            sb.append(current).append(" ");

            for (int next : graph.get(current)) {
                indegree[next]--; // 선행 문제 해결, 차수 감소

                // 차수가 0이 된 문제를 PQ에 삽입
                if (indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}