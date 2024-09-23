import java.util.Scanner;

public class BJ10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

        long[] S = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + A[i];
        }

        int[] C = new int[M + 1];
        int result = 0;
        for (int i = 1; i <= N; i++) {
            int remainder = (int) S[i] % M;

            if (remainder == 0)
                result++;

            C[remainder]++;
        }


        for (int i = 0; i < M; i++) {
            if (C[i] > 1)
                result = result + (C[i] * (C[i] -1) / 2);
        }

        System.out.println(result);
    }
}