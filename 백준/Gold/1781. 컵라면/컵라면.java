import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Homework> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramyeon = Integer.parseInt(st.nextToken());
            list.add(new Homework(deadline, ramyeon));
        }

        // 데드라인 기준 오름차순 정렬
        Collections.sort(list, (h1, h2) -> h1.deadline - h2.deadline);

        // 컵라면 수를 담을 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Homework h : list) {
            pq.add(h.ramyeon);
            
            // 큐의 크기가 데드라인을 초과하면 가장 보상이 적은 것 포기
            if (pq.size() > h.deadline) {
                pq.poll();
            }
        }

        long totalRamyeon = 0;
        while (!pq.isEmpty()) {
            totalRamyeon += pq.poll();
        }

        System.out.println(totalRamyeon);
    }

    static class Homework {
        int deadline;
        int ramyeon;
        
        Homework(int deadline, int ramyeon) {
            this.deadline = deadline;
            this.ramyeon = ramyeon;
        }
    }
}