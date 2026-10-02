import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int[] start = new int[2];
        int[] lever = new int[2];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (c == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }
        
        int timeToLever = bfs(maps, start, 'L');
        if (timeToLever == -1)
            return -1;
        
        int timeToExit = bfs(maps, lever, 'E');
        if (timeToExit == -1)
            return -1;
        
        return timeToLever + timeToExit;
    }
    
    private int bfs(String[] maps, int[] startPos, char target) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{ startPos[0], startPos[1], 0 });
        visited[startPos[0]][startPos[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            
            if (maps[r].charAt(c) == target) {
                return dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (!visited[nr][nc] && maps[nr].charAt(nc) != 'X') {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc, dist + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}