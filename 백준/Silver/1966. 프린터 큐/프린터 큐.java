import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < n; i++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{i, importance});
                priorityQueue.offer(importance);
            }

            int printOrder = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                if (current[1] == priorityQueue.peek()) {
                    priorityQueue.poll();
                    printOrder++;

                    if (current[0] == m) {
                        sb.append(printOrder).append("\n");
                        break;
                    }
                } else {
                    queue.offer(current);
                }
            }
        }

        System.out.print(sb);
    }
}
