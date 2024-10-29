import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);
        }

        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = a[i] * b[i];
            sum += a[i];
        }

        System.out.println(sum);
    }
}