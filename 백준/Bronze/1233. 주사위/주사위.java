import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int s3 = Integer.parseInt(st.nextToken());

        int[] counts = new int[81];

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    int sum = i + j + k;
                    counts[sum]++;
                }
            }
        }

        int maxCount = 0;
        int answer = 0;

        for (int i = 3; i <= 80; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                answer = i;
            }
        }

        System.out.println(answer);
    }
}