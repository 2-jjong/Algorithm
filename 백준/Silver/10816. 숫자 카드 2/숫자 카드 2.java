import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cardCountMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            cardCountMap.put(number, cardCountMap.getOrDefault(number, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int searchCard = Integer.parseInt(st.nextToken());
            int result = cardCountMap.getOrDefault(searchCard, 0);
            sb.append(result).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}