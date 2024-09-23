import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int startIndex = 0;
        int endIndex = N - 1;
        int count = 0;
        while (startIndex < endIndex) {
            int sum = A[startIndex] + A[endIndex];
            if (sum == M) {
                count++;
                startIndex++;
                endIndex--;
            } else if (sum < M) {
                startIndex++;
            } else if (sum > M) {
                endIndex--;
            }
        }

        System.out.println(count);
        br.close();
    }
}
