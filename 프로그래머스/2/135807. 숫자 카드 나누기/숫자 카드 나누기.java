class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = getGcd(gcdA, arrayA[i]);
            gcdB = getGcd(gcdB, arrayB[i]);
        }
        
        int answerA = 0;
        int answerB = 0;
        
        if (isValid(gcdA, arrayB)) {
            answerA = gcdA;
        }
        
        if (isValid(gcdB, arrayA)) {
            answerB = gcdB;
        }
        
        return Math.max(answerA, answerB);
    }
    
    private int getGcd(int a, int b) {
        if (a % b == 0)
            return b;
        
        return getGcd(b, a % b);
    }
    
    private boolean isValid(int gcd, int[] array) {
        if (gcd == 1) return false;
        
        for (int num : array) {
            if (num % gcd == 0) {
                return false;
            }
        }
        
        return true;
    }
}