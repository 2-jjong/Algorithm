import java.util.*;
import java.io.*;

public class Main {
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        isPrime = new boolean[N + 1];
        
        Arrays.fill(isPrime, true);
        eratosthenes();

        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void eratosthenes() {
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < isPrime.length; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}