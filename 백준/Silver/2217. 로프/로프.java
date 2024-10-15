import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int max = 0;
        for (int i = 0; i < N; i++) {
            B[i] = A[i] * (N - i);
            if (max < B[i]) {
                max = B[i];
            }
        }

        System.out.println(max);
    }
}