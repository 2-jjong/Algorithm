import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;

        for (int i = N - 1; i > 0; i--) {
            String number = String.valueOf(i);
            int sum = 0;
            sum += i;

            for (char c : number.toCharArray()) {
                sum += c - '0';
            }

            if(sum == N)
                min = Math.min(min, i);
        }
        
        if(min == Integer.MAX_VALUE)
            min = 0;

        System.out.println(min);
    }
}