import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 이동 횟수 계산
        sb.append((int) (Math.pow(2, N) - 1)).append("\n");

        // 하노이 탑 재귀 수행
        hanoi(N, 1, 2, 3);

        System.out.println(sb.toString().trim());
    }
    
    static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        // N-1개를 시작점에서 보조점으로 옮김
        hanoi(n - 1, start, end, mid);

        // 제일 큰 원판을 시작점에서 목적지로 옮김
        sb.append(start).append(" ").append(end).append("\n");

        // 보조점에 있던 N-1개를 다시 목적지로 옮김
        hanoi(n - 1, mid, start, end);
    }
}