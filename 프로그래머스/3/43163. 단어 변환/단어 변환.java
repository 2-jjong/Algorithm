import java.util.*;

class Solution {
    static class Node {
        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        boolean exists = false;
        for (String w : words) {
            if (w.equals(target)) {
                exists = true;
                break;
            }
        }
        if (!exists) return 0;

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.add(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.word.equals(target)) {
                return current.count;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], current.count + 1));
                }
            }
        }

        return 0;
    }

    private boolean canConvert(String w1, String w2) {
        int diffCount = 0;
        
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diffCount++;
            }
        }
        
        return diffCount == 1;
    }
}