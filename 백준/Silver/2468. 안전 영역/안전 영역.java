import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int maxSafeZones = 1; // 비가 아예 안 올 경우 최소 1개

        for (int h = 0; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int currentSafeZones = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > h && !visited[i][j]) {
                        dfs(i, j, h);
                        currentSafeZones++;
                    }
                }
            }
            
            maxSafeZones = Math.max(maxSafeZones, currentSafeZones);
        }

        System.out.println(maxSafeZones);
    }

    static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny] > h && !visited[nx][ny]) {
                    dfs(nx, ny, h);
                }
            }
        }
    }
}