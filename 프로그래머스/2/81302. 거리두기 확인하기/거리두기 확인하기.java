import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            if (checkPlace(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private boolean checkPlace(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r].charAt(c) == 'P') {
                    if (!bfs(place, r, c)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean bfs(String[] place, int startR, int startC) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        
        queue.offer(new int[]{startR, startC, 0});
        visited[startR][startC] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            
            if (dist > 0 && place[r].charAt(c) == 'P') {
                return false;
            }
            
            if (dist < 2) {
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    
                    if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !visited[nr][nc]) {
                        if (place[nr].charAt(nc) != 'X') {
                            visited[nr][nc] = true;
                            queue.offer(new int[]{nr, nc, dist + 1});
                        }
                    }
                }
            }
        }
        
        return true;
    }
}