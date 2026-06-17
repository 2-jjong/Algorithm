import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            
            if (isValid(rotated)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                
                char open = stack.peek();
                
                if (ch == ']' && open == '[')
                    stack.pop();
                else if (ch == '}' && open == '{')
                    stack.pop();
                else if (ch == ')' && open == '(')
                    stack.pop();
                else
                    return false;
            }
        }
        
        return stack.isEmpty();
    }
}