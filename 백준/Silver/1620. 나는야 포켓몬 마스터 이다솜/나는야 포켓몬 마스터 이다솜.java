import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, String> pokemonMap1 = new HashMap<>();
        Map<String, Integer> pokemonMap2 = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            pokemonMap1.put(i + 1, str);
            pokemonMap2.put(str, i + 1);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            if (isNumeric(str)) {
                int pokemonNumber = Integer.parseInt(str);
                sb.append(pokemonMap1.get(pokemonNumber)).append("\n");
            } else {
                int pokemonNumber = pokemonMap2.get(str);
                sb.append(pokemonNumber).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}