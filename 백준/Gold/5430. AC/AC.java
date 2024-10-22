import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String commands = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<Integer> deque = new LinkedList<>();
            if (N > 0) {
                input = input.substring(1, input.length() - 1);
                String[] numberStr = input.split(",");
                for (String number : numberStr) {
                    deque.add(Integer.parseInt(number));
                }
            }

            boolean errorFlag = false;
            boolean reverseFlag = false;

            for (char command : commands.toCharArray()) {
                if (command == 'R') {
                    reverseFlag = !reverseFlag;
                } else if (command == 'D') {
                    if (deque.isEmpty()) {
                        errorFlag = true;
                        sb.append("error").append('\n');
                        break;
                    }

                    if (reverseFlag)
                        deque.pollLast();
                    else
                        deque.pollFirst();
                }
            }

            if (!errorFlag) {
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (reverseFlag) {
                        sb.append(deque.removeLast());
                    } else {
                        sb.append(deque.removeFirst());
                    }
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append('\n');
            }
        }

        System.out.println(sb);
    }
}