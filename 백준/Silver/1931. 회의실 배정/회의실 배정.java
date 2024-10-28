import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int startTime = Integer.parseInt(str[0]);
            int endTime = Integer.parseInt(str[1]);
            rooms[i] = new Room(startTime, endTime);
        }
        Arrays.sort(rooms);

        int result = 0;
        int currentEntTime = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].startTime >= currentEntTime) {
                currentEntTime = rooms[i].endTime;
                result++;
            }
        }


        System.out.println(result);
    }

    public static class Room implements Comparable<Room> {
        int startTime;
        int endTime;

        public Room(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Room o) {
            if (this.endTime == o.endTime)
                return startTime - o.startTime;

            return endTime - o.endTime;
        }
    }
}