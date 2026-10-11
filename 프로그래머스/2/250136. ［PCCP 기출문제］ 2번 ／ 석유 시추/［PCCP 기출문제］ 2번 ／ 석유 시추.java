import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int[] oilPerColumn = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    
                    int size = 0;
                    Set<Integer> cols = new HashSet<>();
                    
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int r = current[0];
                        int c = current[1];
                        
                        size++;
                        cols.add(c);
                        
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            
                            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                                if (land[nr][nc] == 1 && !visited[nr][nc]) {
                                    visited[nr][nc] = true;
                                    queue.offer(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                    
                    for (int col : cols) {
                        oilPerColumn[col] += size;
                    }
                }
            }
        }
        
        int maxOil = 0;
        for (int oil : oilPerColumn) {
            maxOil = Math.max(maxOil, oil);
        }
        
        return maxOil;
    }
}