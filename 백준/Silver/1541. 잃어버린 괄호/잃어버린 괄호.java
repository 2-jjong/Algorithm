import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] str = input.split("-");
        int ans = 0;

        for (int i = 0; i < str.length; i++) {
            int number = sum(str[i]);
            if (i == 0)
                ans += number;
            else
                ans -= number;
        }

        System.out.println(ans);

    }

    public static int sum(String input) {
        String[] str = input.split("[+]");
        int sum = 0;

        for (int i = 0; i < str.length; i++) {
            sum += Integer.parseInt(str[i]);
        }

        return sum;
    }

}