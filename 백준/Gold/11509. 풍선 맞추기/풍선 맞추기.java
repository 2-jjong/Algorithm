import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] balloons = new int[N];
        int[] arrows = new int[1000001];
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            
            if (arrows[h] > 0) {
                arrows[h]--;
                arrows[h - 1]++;
            } else {
                count++;
                arrows[h - 1]++;
            }
        }

        System.out.println(count);
    }
}