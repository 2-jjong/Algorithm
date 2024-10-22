import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            priorityQueue.add(Integer.parseInt(str));
        }

        int ans = 0;
        while (priorityQueue.size() > 1) {
            int firstCards = priorityQueue.poll();
            int secondCards = priorityQueue.poll();
            ans += firstCards + secondCards;

            priorityQueue.add(firstCards + secondCards);
        }

        sb.append(ans);

        System.out.println(sb);
    }
}