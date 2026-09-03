import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String currentWord = words[i];
            
            if (prevWord.charAt(prevWord.length() - 1) != currentWord.charAt(0) 
                || usedWords.contains(currentWord)) {
                
                int person = (i % n) + 1;
                int turn = (i / n) + 1;
                
                return new int[]{person, turn};
            }
            
            usedWords.add(currentWord);
        }
        
        return new int[]{0, 0};
    }
}