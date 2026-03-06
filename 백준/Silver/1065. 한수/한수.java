import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count;

        if (N < 100) {
            count = N;
        } else {
            count = 99; // 99까지 미리 카운트
            
            // 100부터 N까지 한 수인지 검사
            for (int i = 100; i <= N; i++) {
                if (i == 1000)
                    break;
                
                if (isValid(i)) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }

    public static boolean isValid(int n) {
        int hundreds = n / 100;
        int tens = (n / 10) % 10;
        int ones = n % 10;

        if ((hundreds - tens) == (tens - ones)) {
            return true;
        }
        
        return false;
    }
}