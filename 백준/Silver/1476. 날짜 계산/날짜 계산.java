import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 1;
        while (true) {
            if ((year - 1) % 15 + 1 == E && (year - 1) % 28 + 1 == S && (year - 1) % 19 + 1 == M)
                break;
            
            year++;
        }

        System.out.println(year);
    }
}