import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int dequeNumber;
            switch (command) {
                case 1:
                    dequeNumber = Integer.parseInt(st.nextToken());
                    deque.addFirst(dequeNumber);
                    break;
                case 2:
                    dequeNumber = Integer.parseInt(st.nextToken());
                    deque.addLast(dequeNumber);
                    break;
                case 3:
                    dequeNumber = deque.isEmpty() ? -1 : deque.pollFirst();
                    sb.append(dequeNumber).append("\n");
                    break;
                case 4:
                    dequeNumber = deque.isEmpty() ? -1 : deque.pollLast();
                    sb.append(dequeNumber).append("\n");
                    break;
                case 5:
                    dequeNumber = deque.size();
                    sb.append(dequeNumber).append("\n");
                    break;
                case 6:
                    dequeNumber = deque.isEmpty() ? 1 : 0;
                    sb.append(dequeNumber).append("\n");
                    break;
                case 7:
                    dequeNumber = deque.isEmpty() ? -1 : deque.getFirst();
                    sb.append(dequeNumber).append("\n");
                    break;
                case 8:
                    dequeNumber = deque.isEmpty() ? -1 : deque.getLast();
                    sb.append(dequeNumber).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}