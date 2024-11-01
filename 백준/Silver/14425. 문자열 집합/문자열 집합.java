import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> stringSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            stringSet.add(br.readLine());
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            String str = br.readLine();

            if (stringSet.contains(str)) {
                result++;
            }
        }

        System.out.println(result);
    }
}