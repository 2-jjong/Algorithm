import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] height = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[N + 1]; // 보이는 건물의 수
        int[] nearIdx = new int[N + 1]; // 가장 가까운 건물의 인덱스
        Arrays.fill(nearIdx, -1);

        Stack<Integer> stack = new Stack<>();

        // 왼쪽에 보이는 건물 찾기
        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }
            
            count[i] = stack.size();
            
            if (!stack.isEmpty()) {
                nearIdx[i] = stack.peek();
            }
            
            stack.push(i);
        }

        stack.clear();

        // 오른쪽에 보이는 건물 찾기
        for (int i = N; i >= 1; i--) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }
            
            int rightCount = stack.size();
            if (rightCount > 0) {
                int nearRight = stack.peek();
                
                if (nearIdx[i] == -1 || Math.abs(nearRight - i) < Math.abs(nearIdx[i] - i)) {
                    nearIdx[i] = nearRight;
                }
            }
            
            count[i] += rightCount;
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                sb.append(0).append("\n");
            } else {
                sb.append(count[i]).append(" ").append(nearIdx[i]).append("\n");
            }
        }
        
        System.out.print(sb.toString().trim());
    }
}