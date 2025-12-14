class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            char converted = convertChar(ch, skip, index);
            answer.append(converted);
        }
        
        return answer.toString();
    }
    
    private char convertChar(char ch, String skip, int index) {
        char current = ch;
        int count = 0;
        
        while (count < index) {
            current++;
            
            // z를 넘어가면 a로 순환
            if (current > 'z') {
                current = 'a';
            }
            
            // skip에 포함되지 않은 문자만 카운트
            if (skip.indexOf(current) == -1) {
                count++;
            }
        }
        
        return current;
    }
}