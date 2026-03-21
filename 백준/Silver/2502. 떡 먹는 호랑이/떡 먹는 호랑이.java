import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken()); // 할머니가 넘어온 날
        int K = Integer.parseInt(st.nextToken()); // 그날 준 떡의 개수

        // 각 날짜별로 A와 B가 몇 번씩 더해지는지 저장할 배열
        int[] x = new int[D + 1];
        int[] y = new int[D + 1];

        // 초기 상태 설정
        x[1] = 1; y[1] = 0;
        x[2] = 0; y[2] = 1;

        // 3일차부터 D일까지
        for (int i = 3; i <= D; i++) {
            x[i] = x[i - 1] + x[i - 2];
            y[i] = y[i - 1] + y[i - 2];
        }

        int countA = x[D];
        int countB = y[D];

        // a를 1부터 늘려가며 조건에 맞는 b 찾기
        for (int a = 1; a <= K; a++) {
            int remaining = K - (countA * a);
            
            if (remaining > 0 && remaining % countB == 0) {
                int b = remaining / countB;
                
                if (a < b) {
                    System.out.println(a);
                    System.out.println(b);
                    return;
                }
            }
        }
    }
}