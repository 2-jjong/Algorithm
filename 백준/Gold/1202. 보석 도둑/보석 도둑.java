import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 보석은 무게 기준 오름차순, 가방도 용량 기준 오름차순 정렬
        Arrays.sort(jewels, (j1, j2) -> j1.m - j2.m);
        Arrays.sort(bags);

        // 최대힙으로 가격이 높은 순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long totalPrice = 0;
        int jewelIdx = 0;

        // 작은 가방부터 순회
        for (int i = 0; i < K; i++) {
            // 현재 가방에 담을 수 있는 무게의 보석들을 모두 큐에 삽입
            while (jewelIdx < N && jewels[jewelIdx].m <= bags[i]) {
                pq.add(jewels[jewelIdx].v);
                jewelIdx++;
            }

            // 큐가 비어있지 않다면 가장 비싼 보석 하나를 가방에 담음
            if (!pq.isEmpty()) {
                totalPrice += pq.poll();
            }
        }

        System.out.println(totalPrice);
    }

    static class Jewel {
        int m, v;
        Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}