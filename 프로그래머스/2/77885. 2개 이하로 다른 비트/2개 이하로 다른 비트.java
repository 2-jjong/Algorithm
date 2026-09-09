class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];
            
            if (x % 2 == 0) {
                answer[i] = x + 1;
            } else {
                String binStr = "0" + Long.toBinaryString(x);
                
                int lastZeroIdx = binStr.lastIndexOf("0");
                
                String nextBinStr = binStr.substring(0, lastZeroIdx) + "10" + binStr.substring(lastZeroIdx + 2);
                
                answer[i] = Long.parseLong(nextBinStr, 2);
            }
        }
        
        return answer;
    }
}