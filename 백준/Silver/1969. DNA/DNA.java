import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] dna = new String[N];
        for (int i = 0; i < N; i++) {
            dna[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        int totalDistance = 0;
        char[] dnaBase = {'A', 'C', 'G', 'T'};
        for (int j = 0; j < M; j++) {
            int[] count = new int[4];
            
            for (int i = 0; i < N; i++) {
                char ch = dna[i].charAt(j);
                
                if (ch == 'A')
                    count[0]++;
                else if (ch == 'C')
                    count[1]++;
                else if (ch == 'G')
                    count[2]++;
                else if (ch == 'T')
                    count[3]++;
            }

            int idx = 0;
            for (int k = 1; k < 4; k++) {
                if (count[k] > count[idx]) {
                    idx = k;
                }
            }

            sb.append(dnaBase[idx]);
            totalDistance += (N - count[idx]);
        }
        
        sb.append("\n").append(totalDistance);
        System.out.println(sb.toString().trim());
    }
}