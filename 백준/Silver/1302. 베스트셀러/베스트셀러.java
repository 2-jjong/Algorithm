import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> bookMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            bookMap.put(title, bookMap.getOrDefault(title, 0) + 1);
        }

        int maxCount = 0;
        String bestSeller = "";
        
        for (String title : bookMap.keySet()) {
            int count = bookMap.get(title);

            if (count > maxCount) {
                maxCount = count;
                bestSeller = title;
            } 
            else if (count == maxCount) {
                if (title.compareTo(bestSeller) < 0) {
                    bestSeller = title;
                }
            }
        }

        System.out.println(bestSeller);
    }
}