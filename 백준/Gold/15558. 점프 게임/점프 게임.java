import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[2][N];
        visited = new boolean[2][N];
        for (int i = 0; i < 2; i++) {
            String line = br.readLine();
            
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs() ? 1 : 0);
    }

    static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        // {줄 번호, 칸 번호, 시간}
        q.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            int time = current[2];
            
            // 세 가지 이동 방법
            int[][] nextMoves = {
                {r, c + 1},      // 앞으로 한 칸
                {r, c - 1},      // 뒤로 한 칸
                {1 - r, c + K}   // 반대편 줄로 K칸 점프
            };

            for (int[] next : nextMoves) {
                int nr = next[0];
                int nc = next[1];

                // 탈출 성공
                if (nc >= N)
                    return true;

                // 이동 가능한지 확인
                if (nc >= 0 && map[nr][nc] == 1 && nc > time && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, time + 1});
                }
            }
        }
        
        return false;
    }
}