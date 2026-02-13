import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 심사대 개수
        long M = Long.parseLong(st.nextToken()); // 총 인원수

        long[] times = new long[N];
        long maxTime = 0;
        for (int i = 0; i < N; i++) {
            times[i] = Long.parseLong(br.readLine());
            maxTime = Math.max(maxTime, times[i]);
        }

        long low = 0;
        long high = maxTime * M; // 가장 오래 걸리는 경우
        long result = high;

        // 이분 탐색
        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            // mid 시간 동안 각 심사대에서 처리 가능한 총 인원 합산
            for (long time : times) {
                sum += mid / time;
                
                if (sum >= M)
                    break;
            }

            if (sum >= M) {
                // M명 이상 처리 가능하므로 시간을 줄인다
                result = mid;
                high = mid - 1;
            } else {
                // M명 처리가 불가능하므로 시간을 늘린다
                low = mid + 1;
            }
        }

        System.out.println(result);
    }
}