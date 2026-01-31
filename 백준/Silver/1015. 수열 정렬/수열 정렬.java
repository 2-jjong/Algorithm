import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 원본 값과 원래 인덱스를 함께 저장하기 위한 클래스 배열
        Node[] A = new Node[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = new Node(Integer.parseInt(st.nextToken()), i);
        }

        // 값 기준으로 오름차순 정렬
        // 값이 같다면 원래 인덱스 순서대로 정렬
        Arrays.sort(A, (n1, n2) -> {
            if (n1.val == n2.val) return n1.idx - n2.idx;
            return n1.val - n2.val;
        });

        // 정렬된 상태에서 각 원소가 원래 몇 번째 칸이었는지 확인하여 P 배열 생성
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[A[i].idx] = i;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int x : P) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());
    }

    static class Node {
        int val;
        int idx;
        
        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}