import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Room>[][] switches;
    static boolean[][] isLight;    // 불이 켜져 있는지 확인하는 배열
    static boolean[][] isVisited;  // 방문했는지 확인하는 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        switches = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) switches[i][j] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switches[x][y].add(new Room(a, b));
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Room> q = new LinkedList<>();
        isLight = new boolean[N + 1][N + 1];
        isVisited = new boolean[N + 1][N + 1];

        // 시작점 (1, 1) 설정
        q.add(new Room(1, 1));
        isLight[1][1] = true;
        isVisited[1][1] = true;
        int count = 1; // 불이 켜진 방의 개수

        while (!q.isEmpty()) {
            Room curr = q.poll();

            // 현재 방에 있는 스위치로 불 켜기
            for (Room next : switches[curr.x][curr.y]) {
                if (!isLight[next.x][next.y]) {
                    isLight[next.x][next.y] = true;
                    count++;
                    
                    // 만약 불을 켠 방이 이미 방문한 방과 인접해 있다면 그 방에 방문 가능
                    if (isConnected(next.x, next.y)) {
                        isVisited[next.x][next.y] = true;
                        q.add(new Room(next.x, next.y));
                    }
                }
            }

            // 현재 방에서 상하좌우 인접한 방 탐색
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

                // 불이 켜져 있고 아직 방문 안 했다면 큐에 추가
                if (isLight[nx][ny] && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    q.add(new Room(nx, ny));
                }
            }
        }
        return count;
    }

    // 해당 좌표 주변에 이미 방문한 방이 있는지 확인
    static boolean isConnected(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 1 || nx > N || ny < 1 || ny > N)
                continue;
            
            if (isVisited[nx][ny])
                return true;
        }
        return false;
    }

    static class Room {
        int x;
        int y;
        
        Room(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}