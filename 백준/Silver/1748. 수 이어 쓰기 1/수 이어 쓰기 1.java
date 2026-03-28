import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        int length = 1;
        int start = 1;

        while (start <= N) {
            int end = start * 10 - 1;
            
            if (end > N) {
                end = N;
            }

            sum += (long) (end - start + 1) * length;
            
            start *= 10;
            length++;
        }

        System.out.println(sum);
    }
}