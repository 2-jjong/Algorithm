import java.util.*;

class Solution {
    private boolean[] visited;
    private String[] answer;

    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        visited = new boolean[n];
        answer = new String[n + 1];

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        answer[0] = "ICN";

        dfs("ICN", 0, tickets, n);

        return answer;
    }

    private boolean dfs(String current, int depth, String[][] tickets, int n) {
        if (depth == n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                answer[depth + 1] = tickets[i][1];

                if (dfs(tickets[i][1], depth + 1, tickets, n)) {
                    return true;
                }

                visited[i] = false;
            }
        }

        return false;
    }
}