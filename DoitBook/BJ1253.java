import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int startIndex = 0;
            int endIndex = N - 1;
            while (startIndex < endIndex) {
                if (A[startIndex] + A[endIndex] == A[i]) {
                    if (startIndex != i && endIndex != i) {
                        count++;
                        break;
                    } else if (startIndex == i) {
                        startIndex++;
                    } else if (endIndex == i) {
                        endIndex--;
                    }
                } else if (A[startIndex] + A[endIndex] < A[i]) {
                    startIndex++;
                } else if (A[startIndex] + A[endIndex] > A[i]) {
                    endIndex--;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}