import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 최소로 바꿔야 하는 개수
        int minChanges = N - 1;

        // 모든 두 카드의 조합 (i, j)를 선택
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int diffValue = A[j] - A[i];
                int diffIdx = j - i;

                // 공차가 정수가 아니면 등차수열을 만들 수 없음
                if (diffValue % diffIdx != 0)
                    continue;

                int d = diffValue / diffIdx; // 공차
                int firstValue = A[i] - (i * d); // 0번째 인덱스의 예상 값
                
                int count = 0;
                for (int k = 0; k < N; k++) {
                    // k번째 위치에 있어야 할 값
                    if (A[k] != firstValue + k * d) {
                        count++;
                    }
                }
                minChanges = Math.min(minChanges, count);
            }
        }

        System.out.println(minChanges);
    }
}