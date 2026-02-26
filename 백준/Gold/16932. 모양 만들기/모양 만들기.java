import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] groupMap;
    static Map<Integer, Integer> groupSize = new HashMap<>();
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
            }
        }

        // 그룹화
        groupMap = new int[N][M];
        int groupId = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && groupMap[i][j] == 0) {
                    int size = bfs(i, j, groupId);
                    groupSize.put(groupId, size);
                    groupId++;
                }
            }
        }

        // 0을 하나씩 바꿔보며 최대 크기 탐색
        int maxShapeSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    Set<Integer> nearGroups = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];

                        if (ni >= 0 && ni < N && nj >= 0 && nj < M && groupMap[ni][nj] > 0) {
                            nearGroups.add(groupMap[ni][nj]);
                        }
                    }

                    int currentSize = 1;
                    for (int id : nearGroups) {
                        currentSize += groupSize.get(id);
                    }
                    maxShapeSize = Math.max(maxShapeSize, currentSize);
                }
            }
        }

        System.out.println(maxShapeSize);
    }

    static int bfs(int r, int c, int id) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        groupMap[r][c] = id;
        int count = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && groupMap[nr][nc] == 0) {
                    groupMap[nr][nc] = id;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return count;
    }
}