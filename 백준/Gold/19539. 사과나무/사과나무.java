import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int twoPointCount = 0; // 2만큼 키울 수 있는 총 횟수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            sum += h;
            twoPointCount += (h / 2); // 각 나무에서 2씩 뽑아낼 수 있는 최대 횟수
        }

        // 전체 합이 3의 배수여야 하고 2만큼 키우는 횟수가 총 일수보다 크거나 같아야 함
        if (sum % 3 == 0 && twoPointCount >= (sum / 3)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}