import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] A = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            A[i] = Integer.parseInt(br.readLine());
            sum += A[i];
        }

        Arrays.sort(A);

        sb.append(sum / 5).append("\n");
        sb.append(A[2]);

        System.out.println(sb);
    }
}