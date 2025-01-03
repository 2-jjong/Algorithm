import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        LinkedList<Integer> result = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            int moveCount = Integer.parseInt(st.nextToken());
            result.add(i - moveCount - 1, i);
        }
        
        for (int i = 0; i < n; i++) {
            sb.append(result.get(i)).append(" ");
        }
        
        System.out.print(sb.toString().trim());
    }
}