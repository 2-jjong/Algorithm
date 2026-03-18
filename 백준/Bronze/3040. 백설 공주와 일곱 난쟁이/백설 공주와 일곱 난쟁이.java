import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        int totalSum = 0;

        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            totalSum += heights[i];
        }

        int target = totalSum - 100;
        int out1 = -1, out2 = -1;

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (heights[i] + heights[j] == target) {
                    out1 = i;
                    out2 = j;
                    break;
                }
            }
            
            if (out1 != -1)
                break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i == out1 || i == out2)
                continue;
            sb.append(heights[i]).append("\n");
        }
        
        System.out.print(sb.toString().trim());
    }
}