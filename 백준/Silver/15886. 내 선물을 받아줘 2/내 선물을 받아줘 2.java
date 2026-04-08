import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String map = br.readLine();

        int count = 0;
        
        for (int i = 0; i < N - 1; i++) {
            if (map.charAt(i) == 'E' && map.charAt(i + 1) == 'W') {
                count++;
            }
        }

        System.out.println(count);
    }
}