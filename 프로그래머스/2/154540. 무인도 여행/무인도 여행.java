import java.util.*;

class Solution {
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};
    private boolean[][] visited;
    private int rows, cols;

    public int[] solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();
        visited = new boolean[rows][cols];
        
        List<Integer> islandFoodList = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int totalFood = dfs(i, j, maps);
                    islandFoodList.add(totalFood);
                }
            }
        }

        if (islandFoodList.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(islandFoodList);
        int[] answer = new int[islandFoodList.size()];
        for (int i = 0; i < islandFoodList.size(); i++) {
            answer[i] = islandFoodList.get(i);
        }

        return answer;
    }

    private int dfs(int x, int y, String[] maps) {
        visited[x][y] = true;
        
        int food = maps[x].charAt(y) - '0';

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    food += dfs(nx, ny, maps);
                }
            }
        }

        return food;
    }
}