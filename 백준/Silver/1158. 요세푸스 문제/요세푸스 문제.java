import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                sb.append(queue.poll());
            } else {
                for (int i = 0; i < K - 1; i++) {
                    int number = queue.poll();
                    queue.add(number);
                }
                sb.append(queue.poll()).append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}