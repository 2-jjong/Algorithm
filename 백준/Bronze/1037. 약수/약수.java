import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = Integer.parseInt(br.readLine());
        
        int[] divisors = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < count; i++) {
            divisors[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(divisors);
        
        int min = divisors[0];
        int max = divisors[count - 1];

        System.out.println((long) min * max);
    }
}