import java.util.*;
import java.io.*;

public class Main {
    static int N, M, maxStones = 0;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> emptySpaces = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (map[i][j] == 0)
                    emptySpaces.add(new int[]{i, j});
            }
        }

        // 빈칸 중 2개를 고르는 모든 조합 시도
        int size = emptySpaces.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int[] p1 = emptySpaces.get(i);
                int[] p2 = emptySpaces.get(j);

                // 돌 2개 놓기
                map[p1[0]][p1[1]] = 1;
                map[p2[0]][p2[1]] = 1;

                maxStones = Math.max(maxStones, calculate());

                // 백트래킹
                map[p1[0]][p1[1]] = 0;
                map[p2[0]][p2[1]] = 0;
            }
        }

        System.out.println(maxStones);
    }

    static int calculate() {
        visited = new boolean[N][M];
        int total = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2 && !visited[i][j]) {
                    total += getGroupSize(i, j);
                }
            }
        }
        return total;
    }

    static int getGroupSize(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        int count = 0;
        boolean canEscape = false;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if (map[nr][nc] == 0) {
                    canEscape = true;
                } else if (map[nr][nc] == 2 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        return canEscape ? 0 : count;
    }
}