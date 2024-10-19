import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String N = br.readLine();
        List<Integer> numbers = new ArrayList<>();
        for (char c : N.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }

        numbers.sort(Collections.reverseOrder());

        for (Integer number : numbers) {
            sb.append(number);
        }

        System.out.println(sb);
    }
}