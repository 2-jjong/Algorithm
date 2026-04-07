import java.util.*;
import java.io.*;

public class Main {
    static String[][] board = new String[5][5];
    static HashSet<String> set = new HashSet<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            board[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, board[i][j]);
            }
        }

        System.out.println(set.size());
    }

    static void dfs(int x, int y, int depth, String currentStr) {
        if (depth == 5) {
            set.add(currentStr);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(nx, ny, depth + 1, currentStr + board[nx][ny]);
            }
        }
    }
}