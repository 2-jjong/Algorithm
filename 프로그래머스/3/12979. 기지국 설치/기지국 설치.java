class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        int coverage = 2 * w + 1;

        for (int station : stations) {
            int leftStart = station - w;

            if (position < leftStart) {
                int gap = leftStart - position;
                answer += (gap + coverage - 1) / coverage;
            }

            position = station + w + 1;
        }

        if (position <= n) {
            int gap = n - position + 1;
            answer += (gap + coverage - 1) / coverage;
        }

        return answer;
    }
}