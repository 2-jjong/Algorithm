import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Coordinate[] coordinates = new Coordinate[n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            coordinates[i] = new Coordinate(x, y);
        }
        Arrays.sort(coordinates);

        for (int i = 0; i < n; i++) {
            sb.append(coordinates[i].toString()).append("\n");
        }

        System.out.println(sb);
    }

    public static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (x == o.x)
                return y - o.y;

            return x - o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}