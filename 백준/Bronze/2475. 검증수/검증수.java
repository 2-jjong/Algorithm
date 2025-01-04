import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] inputs = br.readLine().split(" ");
        int sum = 0;
        
        for (String input : inputs) {
            int num = Integer.parseInt(input);
            sum += num * num;
        }
        
        sb.append(sum % 10);
        System.out.print(sb);
    }
}
