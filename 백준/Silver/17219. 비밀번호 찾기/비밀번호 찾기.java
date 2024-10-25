import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> passwordMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            passwordMap.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            sb.append(passwordMap.get(site)).append('\n');
        }

        System.out.println(sb);
    }
}