import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] parent = new int[100001]; // 역추적 배열
    static int[] time = new int[100001];   // 도달 시간 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 출발지와 목적지가 같은 경우 처리
        if (N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        sb.append(time[K]).append("\n");

        // 경로 역추적
        Stack<Integer> stack = new Stack<>();
        int current = K;
        while (current != N) {
            stack.push(current);
            current = parent[current];
        }
        stack.push(N);

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        Arrays.fill(time, -1);
        time[N] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == K) return;

            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                // 범위를 벗어나지 않고 아직 방문하지 않은 위치라면
                if (next >= 0 && next <= 100000 && time[next] == -1) {
                    time[next] = time[current] + 1;
                    parent[next] = current; // 이전 위치 기록
                    q.add(next);
                }
            }
        }
    }
}