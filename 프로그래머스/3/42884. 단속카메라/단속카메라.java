import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int camera = -30001;

        for (int i = 0; i < routes.length; i++) {
            if (camera < routes[i][0]) {
                camera = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}