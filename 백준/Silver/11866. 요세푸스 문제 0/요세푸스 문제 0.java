import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        sb.append("<");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < k - 1; j++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");


        System.out.print(sb);
    }
}