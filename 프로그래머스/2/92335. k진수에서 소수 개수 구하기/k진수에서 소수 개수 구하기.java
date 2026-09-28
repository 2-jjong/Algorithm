class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kBase = Integer.toString(n, k);
        String[] parts = kBase.split("0");
        
        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }
            
            long num = Long.parseLong(part);
            
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}