import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int dequeNumber;
            switch (command) {
                case "push_front":
                    dequeNumber = Integer.parseInt(st.nextToken());
                    deque.addFirst(dequeNumber);
                    break;
                case "push_back":
                    dequeNumber = Integer.parseInt(st.nextToken());
                    deque.addLast(dequeNumber);
                    break;
                case "pop_front":
                    dequeNumber = deque.isEmpty() ? -1 : deque.pollFirst();
                    sb.append(dequeNumber).append("\n");
                    break;
                case "pop_back":
                    dequeNumber = deque.isEmpty() ? -1 : deque.pollLast();
                    sb.append(dequeNumber).append("\n");
                    break;
                case "size":
                    dequeNumber = deque.size();
                    sb.append(dequeNumber).append("\n");
                    break;
                case "empty":
                    dequeNumber = deque.isEmpty() ? 1 : 0;
                    sb.append(dequeNumber).append("\n");
                    break;
                case "front":
                    dequeNumber = deque.isEmpty() ? -1 : deque.getFirst();
                    sb.append(dequeNumber).append("\n");
                    break;
                case "back":
                    dequeNumber = deque.isEmpty() ? -1 : deque.getLast();
                    sb.append(dequeNumber).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}