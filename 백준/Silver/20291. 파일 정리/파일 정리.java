import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> extensionMap = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            String extension = fileName.substring(fileName.indexOf('.') + 1);

            extensionMap.put(extension, extensionMap.getOrDefault(extension, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String key : extensionMap.keySet()) {
            sb.append(key).append(" ").append(extensionMap.get(key)).append("\n");
        }

        System.out.print(sb.toString().trim());
    }
}