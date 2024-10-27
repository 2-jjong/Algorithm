import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (left.isEmpty() || left.peek() > num)
                left.offer(num);
            else
                right.offer(num);

            if (left.size() > right.size() + 1) {
                right.offer(left.poll());
            } else if (left.size() < right.size()) {
                left.offer(right.poll());
            }

            sb.append(left.peek()).append("\n");
        }

        System.out.println(sb);
    }
}