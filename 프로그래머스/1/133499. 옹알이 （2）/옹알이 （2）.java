class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] sounds = {"aya", "ye", "woo", "ma"};

        for (String b : babbling) {
            String prev = "";
            String current = b;
            boolean isValid = true;

            while (current.length() > 0) {
                boolean found = false;
                
                for (String s : sounds) {
                    if (current.startsWith(s) && !s.equals(prev)) {
                        current = current.substring(s.length());
                        prev = s;
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid)
                answer++;
        }
        
        return answer;
    }
}