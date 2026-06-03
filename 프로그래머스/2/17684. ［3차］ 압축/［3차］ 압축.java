import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        
        int dictSize = 1;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            dictionary.put(String.valueOf(ch), dictSize++);
        }

        List<Integer> ansList = new ArrayList<>();
        int i = 0;

        while (i < msg.length()) {
            String w = "";
            int j = i;

            while (j < msg.length() && dictionary.containsKey(msg.substring(i, j + 1))) {
                w = msg.substring(i, j + 1);
                j++;
            }

            ansList.add(dictionary.get(w));

            if (j < msg.length()) {
                String c = String.valueOf(msg.charAt(j));
                dictionary.put(w + c, dictSize++);
            }

            i += w.length();
        }

        int[] answer = new int[ansList.size()];
        for (int k = 0; k < ansList.size(); k++) {
            answer[k] = ansList.get(k);
        }

        return answer;
    }
}