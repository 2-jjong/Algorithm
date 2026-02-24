import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 오름차순 정렬
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int right = 0;

        // 투 포인터 탐색
        for (int left = 0; left < N; left++) {
            
            // 두 수의 차이가 M보다 작으면 right를 뒤로 밀어서 차이를 키움
            while (right < N && nums[right] - nums[left] < M) {
                right++;
            }

            // right가 배열 끝까지 갔으면 더 이상 답이 없음
            if (right == N)
                break;

            // 차이가 M 이상인 것 중 최솟값 갱신
            int currentDiff = nums[right] - nums[left];
            minDiff = Math.min(minDiff, currentDiff);

            // 차이가 딱 M이라면 즉시 종료
            if (minDiff == M)
                break;
        }

        System.out.println(minDiff);
    }
}