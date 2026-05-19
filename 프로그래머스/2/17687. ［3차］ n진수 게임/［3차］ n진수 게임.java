import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder totalStr = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        int targetLength = t * m;
        int num = 0;
        
        while (totalStr.length() < targetLength) {
            totalStr.append(Integer.toString(num, n).toUpperCase());
            num++;
        }
        
        int idx = p - 1;
        for (int i = 0; i < t; i++) {
            answer.append(totalStr.charAt(idx));
            idx += m;
        }
        
        return answer.toString();
    }
}