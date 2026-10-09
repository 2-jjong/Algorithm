import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minDiff = n;

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            int count = bfs(v1, v2, graph, n);

            int diff = Math.abs(count - (n - count));
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    private int bfs(int start, int ignore, List<Integer>[] graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (next == ignore) continue;

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }

        return count;
    }
}