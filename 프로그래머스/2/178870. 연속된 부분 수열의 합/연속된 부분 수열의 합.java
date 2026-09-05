class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int n = sequence.length;
        
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while (true) {
            if (sum == k && (right - left < minLen)) {
                minLen = right - left;
                answer[0] = left;
                answer[1] = right;
            }
            
            if (sum <= k) {
                right++;
                if (right == n) break;
                sum += sequence[right];
            } else {
                sum -= sequence[left];
                left++;
            }
        }
        
        return answer;
    }
}