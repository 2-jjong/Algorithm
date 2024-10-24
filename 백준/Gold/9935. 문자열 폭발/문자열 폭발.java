import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String explosionStr = br.readLine();
        char[] explosionChar = explosionStr.toCharArray();
        int explosionLen = explosionChar.length;

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);

            if (deque.size() >= explosionLen && matchExplosion(deque, explosionChar)) {
                for (int i = 0; i < explosionLen; i++) {
                    deque.pollLast();
                }
            }
        }

        if (deque.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (char c : deque) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }

    private static boolean matchExplosion(Deque<Character> deque, char[] explosionChar) {
        Iterator<Character> it = deque.descendingIterator();

        for (int i = explosionChar.length - 1; i >= 0; i--) {
            if (!it.hasNext() || it.next() != explosionChar[i]) {
                return false;
            }
        }
        return true;
    }
}
