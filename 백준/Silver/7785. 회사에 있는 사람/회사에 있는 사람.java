import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Set<String> nameSet = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            if (str[1].equals("enter"))
                nameSet.add(str[0]);
            else if (str[1].equals("leave"))
                nameSet.remove(str[0]);
        }

        for (String s : nameSet) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}