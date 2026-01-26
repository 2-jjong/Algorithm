import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 강연 정보를 담을 리스트
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(p, d));
        }

        // 마감일(d) 기준 오름차순 정렬
        Collections.sort(lectures, (a, b) -> a.d - b.d);

        // 강연료(p)를 담을 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Lecture l : lectures) {
            pq.add(l.p);
            
            // 만약 담긴 강연 수가 마감일보다 많아지면
            // 가장 싼 강연 하나를 포기
            if (pq.size() > l.d) {
                pq.poll();
            }
        }

        // pq에 남은 강연료 모두 합산
        int total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        System.out.println(total);
    }

    static class Lecture {
        int p, d;
        Lecture(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }
}