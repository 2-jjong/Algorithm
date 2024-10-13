import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n + 1];
        int[] S = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();
            S[i] = S[i - 1] + A[i];
        }

        long result = 0;
        for (int i = 1; i < n; i++) {
            result += (long) A[i] * (S[n] - S[i]);
        }

        System.out.println(result);
    }
}