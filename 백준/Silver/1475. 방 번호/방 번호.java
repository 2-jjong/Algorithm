import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int[] count = new int[10];
        
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            count[num]++;
        }

        int sixNineSum = count[6] + count[9];
        
        if (sixNineSum % 2 == 0) {
            count[6] = sixNineSum / 2;
        } else {
            count[6] = (sixNineSum / 2) + 1;
        }
        count[9] = 0;

        int maxSets = 0;
        for (int i = 0; i < 9; i++) {
            maxSets = Math.max(maxSets, count[i]);
        }

        System.out.println(maxSets);
    }
}