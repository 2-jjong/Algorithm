import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[] x = new int[3];
        int[] y = new int[3];
        
        for (int i = 0; i < 3; i++) {
            String[] inputs = br.readLine().split(" ");
            x[i] = Integer.parseInt(inputs[0]);
            y[i] = Integer.parseInt(inputs[1]);
        }
        
        int xResult = (x[0] == x[1]) ? x[2] : (x[0] == x[2]) ? x[1] : x[0];
        int yResult = (y[0] == y[1]) ? y[2] : (y[0] == y[2]) ? y[1] : y[0];
        
        sb.append(xResult).append(" ").append(yResult);
        
        System.out.print(sb);
    }
}
