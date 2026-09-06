class Solution {
    public int solution(int[] arr) {
        int max = 0;
        
        for (int num : arr) {
            if (num > max) max = num;
        }
        
        int lcm = max;
        while (true) {
            boolean isLcm = true;
            for (int num : arr) {
                if (lcm % num != 0) {
                    isLcm = false;
                    break;
                }
            }
            
            if (isLcm) {
                return lcm;
            }
            
            lcm += max;
        }
    }
}