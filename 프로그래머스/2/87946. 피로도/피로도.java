class Solution {
    private boolean[] visited;
    private int maxDungeons = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        
        return maxDungeons;
    }

    private void dfs(int currentFatigue, int count, int[][] dungeons) {
        maxDungeons = Math.max(maxDungeons, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && currentFatigue >= dungeons[i][0]) {
                visited[i] = true;
                dfs(currentFatigue - dungeons[i][1], count + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}