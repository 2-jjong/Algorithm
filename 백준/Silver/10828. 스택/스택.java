import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String command = st.nextToken().trim();
                switch (command) {
                    case "push":
                        int number = Integer.parseInt(st.nextToken());
                        stack.push(number);
                        break;
                    case "pop":
                        int popNumber = stack.isEmpty() ? -1 : stack.pop();
                        sb.append(popNumber).append("\n");
                        break;
                    case "size":
                        int size = stack.size();
                        sb.append(size).append("\n");
                        break;
                    case "empty":
                        int emptyNumber = stack.isEmpty() ? 1 : 0;
                        sb.append(emptyNumber).append("\n");
                        break;
                    case "top":
                        int topNumber = stack.isEmpty() ? -1 : stack.peek();
                        sb.append(topNumber).append("\n");
                        break;
                }
            }
        }

        System.out.println(sb.toString());
    }
}