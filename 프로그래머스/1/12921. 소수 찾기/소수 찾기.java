class Solution {
    public int solution(int n) {
        boolean[] isPrime = new boolean[n + 1];
        
        // 모든 수를 소수로 초기화
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        // 에라토스테네스의 체 알고리즘
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // i의 배수들을 모두 소수가 아니라고 표시
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // 소수 개수 세기
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        
        return count;
    }
}