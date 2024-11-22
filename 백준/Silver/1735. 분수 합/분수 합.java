import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int numerator = A * D + C * B;
        int denominator = B * D;
        int gcd = 1;

        if (numerator > denominator)
            gcd = gcd(numerator, denominator);
        else
            gcd = gcd(denominator, numerator);

        sb.append(numerator / gcd).append(" ").append(denominator / gcd);

        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if (a % b == 0)
            return b;

        return gcd(b, a % b);
    }
}