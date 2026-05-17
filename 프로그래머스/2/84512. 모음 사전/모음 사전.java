import java.util.*;

class Solution {
    private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
    private List<String> dictionary = new ArrayList<>();

    public int solution(String word) {
        generateWords("");

        return dictionary.indexOf(word) + 1;
    }

    private void generateWords(String current) {
        if (current.length() > 5) {
            return;
        }

        if (!current.isEmpty()) {
            dictionary.add(current);
        }

        for (char vowel : VOWELS) {
            generateWords(current + vowel);
        }
    }
}