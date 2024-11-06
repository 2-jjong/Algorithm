import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int zero = 0;
        int one = 0;
        PriorityQueue<Integer> positiveNumbers = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        PriorityQueue<Integer> negativeNumbers = new PriorityQueue<>();


        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0)
                zero++;
            else if (number == 1)
                one++;
            else if (number < 0)
                negativeNumbers.add(number);
            else if (number > 0)
                positiveNumbers.add(number);
        }

        int sum = 0;
        while (positiveNumbers.size() > 1) {
            sum += positiveNumbers.poll() * positiveNumbers.poll();
        }

        if (!positiveNumbers.isEmpty()) {
            sum += positiveNumbers.poll();
        }

        while (negativeNumbers.size() > 1) {
            sum += negativeNumbers.poll() * negativeNumbers.poll();
        }

        if (!negativeNumbers.isEmpty()) {
            if (zero == 0) {
                sum += negativeNumbers.poll();
            }
        }

        sum += one;

        System.out.println(sum);

    }

}