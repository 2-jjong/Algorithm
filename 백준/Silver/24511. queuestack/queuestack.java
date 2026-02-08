import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        int[] type = new int[N]; // 0: queue, 1: stack
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            // 큐인 경우에만 저장
            if (type[i] == 0) {
                deque.addLast(num);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            
            // 새로운 원소를 앞으로 넣고 뒤에서 나오는 원소를 출력
            deque.addFirst(input);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}