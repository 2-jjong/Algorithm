import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sugar = new int[5001];
        sugar[3] = 1;
        sugar[5] = 1;
        for (int i = 6; i <= N; i++) {
            if (sugar[i - 5] > 0)
                sugar[i] = sugar[i - 5] + 1;
            else if (sugar[i - 3] > 0)
                sugar[i] = sugar[i - 3] + 1;
        }

        if (sugar[N] == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sugar[N]);
    }
}