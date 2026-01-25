import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine()); // 친구 관계 수
            
            // 관계가 F개일 때 등장하는 최대 인원수는 F * 2명
            parent = new int[F * 2];
            count = new int[F * 2];
            
            // 유니온 파인드 배열 초기화
            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
                count[i] = 1;
            }

            Map<String, Integer> map = new HashMap<>();
            int idx = 0;

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();

                // 이름이 처음 나오면 고유 번호 부여
                if (!map.containsKey(f1))
                    map.put(f1, idx++);
                if (!map.containsKey(f2))
                    map.put(f2, idx++);

                // 두 사람을 합치고 네트워크 크기를 구함
                int result = union(map.get(f1), map.get(f2));
                sb.append(result).append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
            count[x] += count[y];
        }
        
        return count[x];
    }
}