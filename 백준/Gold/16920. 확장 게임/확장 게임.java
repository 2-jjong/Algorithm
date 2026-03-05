import java.util.*;
import java.io.*;

public class Main {
    static int N, M, P;
    static int[] S;
    static int[][] map;
    static int[] counts;
    static Queue<int[]>[] q;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        S = new int[P + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[N][M];
        counts = new int[P + 1];
        q = new LinkedList[P + 1];
        for (int i = 1; i <= P; i++) {
            q[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = line.charAt(j);
                if (ch >= '1' && ch <= '9') {
                    int num = ch - '0';
                    map[i][j] = num;
                    counts[num]++;
                    q[num].add(new int[]{i, j});
                } else if (ch == '#') {
                    map[i][j] = -1;
                }
            }
        }

        // 게임 진행
        while (true) {
            boolean moved = false;

            for (int i = 1; i <= P; i++) {
                if (bfs(i)) {
                    moved = true;
                }
            }

            // 모든 플레이어가 더 이상 확장할 수 없으면 종료
            if (!moved)
                break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= P; i++) {
            sb.append(counts[i]).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }

    static boolean bfs(int idx) {
        if (q[idx].isEmpty())
            return false;

        boolean currentMoved = false;
        int distance = S[idx];

        for (int d = 0; d < distance; d++) {
            int size = q[idx].size();
            if (size == 0)
                break;

            for (int s = 0; s < size; s++) {
                int[] cur = q[idx].poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nr = cur[0] + dr[dir];
                    int nc = cur[1] + dc[dir];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                        map[nr][nc] = idx;
                        q[idx].add(new int[]{nr, nc});
                        counts[idx]++;
                        currentMoved = true;
                    }
                }
            }
        }
        
        return currentMoved;
    }
}