import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Guitar[] guitars = new Guitar[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            guitars[i] = new Guitar(str);
        }
        Arrays.sort(guitars);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(guitars[i].serialNumber).append("\n");
        }

        System.out.println(sb);
    }

    public static class Guitar implements Comparable<Guitar> {
        String serialNumber;
        int numberSum = 0;

        public Guitar(String serialNumber) {
            this.serialNumber = serialNumber;
            sumCheck();
        }

        public void sumCheck() {
            for (Character c : serialNumber.toCharArray()) {
                if (c - '0' < 10) {
                    numberSum += c - '0';
                }
            }
        }

        @Override
        public int compareTo(Guitar o) {
            if (serialNumber.length() > o.serialNumber.length())
                return 1;
            else if (serialNumber.length() < o.serialNumber.length())
                return -1;

            if (numberSum > o.numberSum)
                return 1;
            else if (numberSum < o.numberSum)
                return -1;

            return serialNumber.compareTo(o.serialNumber);
        }
    }
}