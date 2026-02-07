import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 풍선의 번호와 이동할 값을 담은 객체를 덱에 저장
        Deque<Balloon> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        while (!deque.isEmpty()) {
            // 현재 풍선을 터뜨림
            Balloon current = deque.pollFirst();
            sb.append(current.id).append(" ");
            
            // 풍선이 다 터졌으면 종료
            if (deque.isEmpty())
                break;

            int move = current.value;

            // 종이에 적힌 숫자만큼 이동
            if (move > 0) {
                // 현재 터뜨린 풍선을 제외했으므로 move-1번 수행
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb.toString().trim());
    }

    static class Balloon {
        int id;
        int value;
        
        Balloon(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }
}