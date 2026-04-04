import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        
        int[] count = new int[10];
        long sum = 0;
        boolean hasZero = false;

        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';
            count[num]++;
            sum += num;
            
            if (num == 0)
                hasZero = true;
        }

        // 30의 배수 조건 체크. 0이 포함되어 있고 자릿수 합이 3의 배수
        if (!hasZero || sum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (count[i] > 0) {
                sb.append(i);
                count[i]--;
            }
        }

        System.out.println(sb.toString().trim());
    }
}