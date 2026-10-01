import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] parsed1 = parse(s1);
                String[] parsed2 = parse(s2);
                
                int headCompare = parsed1[0].compareToIgnoreCase(parsed2[0]);
                
                if (headCompare == 0) {
                    int num1 = Integer.parseInt(parsed1[1]);
                    int num2 = Integer.parseInt(parsed2[1]);
                    return Integer.compare(num1, num2);
                }
                
                return headCompare;
            }
        });
        
        return files;
    }
    
    private String[] parse(String s) {
        int headEnd = 0;
        
        while (headEnd < s.length() && !Character.isDigit(s.charAt(headEnd))) {
            headEnd++;
        }
        
        String head = s.substring(0, headEnd);
        
        int numEnd = headEnd;
        
        while (numEnd < s.length() && Character.isDigit(s.charAt(numEnd)) && numEnd - headEnd < 5) {
            numEnd++;
        }
        
        String number = s.substring(headEnd, numEnd);
        
        return new String[]{ head, number };
    }
}