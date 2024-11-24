import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            long N = Long.parseLong(br.readLine());
            long answer = nextPrime(N);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static long nextPrime(long n) {
        if (n <= 2) return 2;

        long candidate = n;
        if (candidate % 2 == 0 && candidate != 2) {
            candidate++;
        }

        while (!isPrime(candidate)) {
            candidate += 2;
        }

        return candidate;
    }

    public static boolean isPrime(long x) {
        if (x < 2) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;

        for (long i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }

        return true;
    }
}