import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 책의 개수
        int K = Integer.parseInt(st.nextToken()); // 한 번에 들 수 있는 개수

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int maxDist = 0; // 가장 먼 거리

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            maxDist = Math.max(maxDist, Math.abs(num));
            
            if (num > 0)
                positive.add(num);
            else
                negative.add(Math.abs(num));
        }

        // 먼 순서대로 정렬
        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative, Collections.reverseOrder());

        int totalDist = 0;

        // 양수 쪽 처리
        for (int i = 0; i < positive.size(); i += K) {
            totalDist += (positive.get(i) * 2);
        }

        // 음수 쪽 처리
        for (int i = 0; i < negative.size(); i += K) {
            totalDist += (negative.get(i) * 2);
        }

        // 마지막에 가장 먼 곳은 돌아오지 않으므로 한 번 빼기
        int answer = totalDist - maxDist;
        
        System.out.println(answer);
    }
}