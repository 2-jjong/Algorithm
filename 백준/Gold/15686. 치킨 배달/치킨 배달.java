import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
    static int[][] map;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static boolean[] chickenVisited;
    static int answer = Integer.MAX_VALUE;
    
    static void combination(int start, int count) {
        if (count == M) {
            int distSum = 0;
            
            for (int[] h : house) {
                int min = Integer.MAX_VALUE;
                
                for (int i = 0; i < chicken.size(); i++) {
                    if (chickenVisited[i]) {
                        int dist = Math.abs(h[0] - chicken.get(i)[0]) + Math.abs(h[1] - chicken.get(i)[1]);
                        min = Math.min(min, dist);
                    }
                }
                
                distSum += min;
            }
            
            answer = Math.min(answer, distSum);
            return;
        }
        
        for (int i = start; i < chicken.size(); i++) {
            if (!chickenVisited[i]) {
                chickenVisited[i] = true;
                combination(i + 1, count + 1);
                chickenVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (map[i][j] == 1) {
                    house.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }
        
        chickenVisited = new boolean[chicken.size()];
        
        combination(0, 0);
        
        System.out.println(answer);
    }
}