class Solution {
    public int solution(int n) {
        int originalCount = Integer.bitCount(n);
        
        int nextNum = n + 1;
        
        while (true) {
            if (Integer.bitCount(nextNum) == originalCount)
                break;
                
            nextNum++;
        }
        
        return nextNum;
    }
}