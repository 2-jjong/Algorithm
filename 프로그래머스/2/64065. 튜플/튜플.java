import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] groups = s.split("\\}\\,\\{");

        Arrays.sort(groups, (a, b) -> {
            int countA = a.split(",").length;
            int countB = b.split(",").length;
            return Integer.compare(countA, countB);
        });

        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (String group : groups) {
            String[] elements = group.split(",");
            
            for (String element : elements) {
                int num = Integer.parseInt(element);
                
                if (!visited.contains(num)) {
                    visited.add(num);
                    result.add(num);
                }
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}