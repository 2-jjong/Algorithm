import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxRooms = 0;

        for (Lecture lecture : lectures) {
            while (!pq.isEmpty() && pq.peek() <= lecture.startTime) {
                pq.poll();
            }
            pq.offer(lecture.endTime);
            maxRooms = Math.max(maxRooms, pq.size());
        }

        System.out.println(maxRooms);
    }

    public static class Lecture implements Comparable<Lecture> {
        int lectureNumber;
        int startTime;
        int endTime;

        public Lecture(int lectureNumber, int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Lecture o) {
            if (startTime > o.startTime)
                return 1;
            else if (startTime == o.startTime) {
                return Integer.compare(endTime, o.endTime);
            } else
                return -1;
        }
    }
}