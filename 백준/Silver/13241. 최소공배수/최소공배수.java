import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        long gcd = gcd(A, B);

        sb.append(A * B / gcd).append("\n");

        System.out.println(sb);
    }

    public static long gcd(long a, long b) {
        if (a % b == 0)
            return b;

        return gcd(b, a % b);
    }
}