import java.util.Scanner;

public class BJ11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];
        int[] S = new int[N+1];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            if (i == 0) {
                S[i+1] = A[i];
            } else {
                S[i+1] = S[i] + A[i];
            }
        }

        int num1, num2;
        for (int i = 0; i < M; i++) {
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            System.out.println(S[num2] - S[num1 - 1]);
        }
    }
}