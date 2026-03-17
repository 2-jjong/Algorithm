import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static char[] signs;
    static boolean[] visited = new boolean[10];
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        signs = br.readLine().replace(" ", "").toCharArray();

        dfs("", 0);

        Collections.sort(results);

        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));
    }

    static void dfs(String num, int depth) {
        if (depth == k + 1) {
            results.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (depth == 0 || check(num.charAt(depth - 1) - '0', i, signs[depth - 1])) {
                    visited[i] = true;
                    dfs(num + i, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean check(int a, int b, char sign) {
        if (sign == '<')
            return a < b;
        if (sign == '>')
            return a > b;
        
        return false;
    }
}