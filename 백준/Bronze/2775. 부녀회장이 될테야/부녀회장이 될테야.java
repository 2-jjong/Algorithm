import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            
            int[][] apartment = new int[k + 1][n + 1];
            
            for (int i = 0; i <= n; i++) {
                apartment[0][i] = i;
            }
            
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    apartment[i][j] = apartment[i - 1][j] + apartment[i][j - 1];
                }
            }
            
            sb.append(apartment[k][n]).append("\n");
        }
        
        System.out.print(sb);
    }
}