class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }
        
        int leftCount = 0;
        int rightCount = 0;
        int splitIndex = 0;
        
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') leftCount++;
            else rightCount++;
            
            if (leftCount == rightCount) {
                splitIndex = i + 1;
                break;
            }
        }
        
        String u = p.substring(0, splitIndex);
        String v = p.substring(splitIndex);
        
        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            
            String uSub = u.substring(1, u.length() - 1);
            for (int i = 0; i < uSub.length(); i++) {
                if (uSub.charAt(i) == '(') {
                    sb.append(")");
                } else {
                    sb.append("(");
                }
            }
            
            return sb.toString();
        }
    }
    
    private boolean isCorrect(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}