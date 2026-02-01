import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        // 각 변까지의 거리 중 최솟값 찾기
        int minX = Math.min(x, w - x); // 좌우
        int minY = Math.min(y, h - y); // 상하
        int answer = Math.min(minX, minY);
        
        System.out.println(answer);
    }
}