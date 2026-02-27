import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] parent = new int[N + 1];

            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p; // 자식 인덱스에 부모 번호 저장
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            // nodeA의 모든 조상을 따라 올라가며 방문 표시
            boolean[] visited = new boolean[N + 1];
            while (nodeA != 0) {
                visited[nodeA] = true;
                nodeA = parent[nodeA];
            }

            // nodeB가 위로 올라가며 nodeA가 방문했던 조상을 처음 만나는 지점 찾기
            while (nodeB != 0) {
                if (visited[nodeB]) {
                    sb.append(nodeB).append("\n");
                    break;
                }
                nodeB = parent[nodeB];
            }
        }
        
        System.out.print(sb.toString().trim());
    }
}