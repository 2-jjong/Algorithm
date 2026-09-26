class Solution {
    public int[] solution(String s) {
        int transformCount = 0;
        int removedZeros = 0;
        
        while (!s.equals("1")) {
            int originalLength = s.length();
            
            s = s.replace("0", "");
            int newLength = s.length();
            
            removedZeros += (originalLength - newLength);
            
            s = Integer.toBinaryString(newLength);
            
            transformCount++;
        }
        
        return new int[]{transformCount, removedZeros};
    }
}