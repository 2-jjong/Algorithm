import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while (true) {
            str = br.readLine();
            if (str.equals("."))
                break;

            boolean flag = verificationString(str);
            if (flag)
                sb.append("yes").append("\n");
            else
                sb.append("no").append("\n");
        }

        System.out.println(sb);
    }

    public static boolean verificationString(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                    break;
            }
        }

        return stack.isEmpty();
    }
}