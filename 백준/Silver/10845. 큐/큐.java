import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    int pushNumber = Integer.parseInt(st.nextToken());
                    queue.add(pushNumber);
                    break;
                case "pop":
                    int popNumber = queue.isEmpty() ? -1 : queue.poll();
                    sb.append(popNumber).append("\n");
                    break;
                case "size":
                    int queueSize = queue.size();
                    sb.append(queueSize).append("\n");
                    break;
                case "empty":
                    int emptyNumber = queue.isEmpty() ? 1 : 0;
                    sb.append(emptyNumber).append("\n");
                    break;
                case "front":
                    int frontNumber = queue.isEmpty() ? -1 : queue.peek();
                    sb.append(frontNumber).append("\n");
                    break;
                case "back":
                    int backNumber = queue.isEmpty() ? -1 : ((LinkedList<Integer>) queue).getLast();
                    sb.append(backNumber).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}