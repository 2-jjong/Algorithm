import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        int now = 1; // 현재 간식을 받아야 하는 순서

        for (int i = 0; i < N; i++) {
            int person = Integer.parseInt(st.nextToken());

            // 현재 사람이 내 순서라면 바로 통과
            if (person == now) {
                now++;
                
                // 스택에 내 다음 순서가 있는지 확인
                while (!stack.isEmpty() && stack.peek() == now) {
                    stack.pop();
                    now++;
                }
            } else {
                // 순서가 아니라면 대기 공간으로 보냄
                stack.push(person);
            }
        }

        // 스택에 남은 사람들 확인
        while (!stack.isEmpty() && stack.peek() == now) {
            stack.pop();
            now++;
        }

        // 스택이 비어있으면 모두 순서대로 나간 것
        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}