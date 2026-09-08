import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
                list1.add("" + c1 + c2);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
                list2.add("" + c1 + c2);
            }
        }
        
        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }
        
        int intersection = 0;
        int union = list1.size() + list2.size();
        
        for (String s : list1) {
            if (list2.remove(s)) {
                intersection++;
            }
        }
        
        union -= intersection; 
        
        return (int) (((double) intersection / union) * 65536);
    }
}