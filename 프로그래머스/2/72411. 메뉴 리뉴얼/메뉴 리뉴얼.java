import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        for (int c : course) {
            map.clear();
            
            for (String order : orders) {
                combination("", order, c, 0);
            }

            if (map.isEmpty()) continue;

            int max = Collections.max(map.values());
            if (max < 2) continue;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    answerList.add(entry.getKey());
                }
            }
        }

        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    private void combination(String current, String order, int length, int idx) {
        if (current.length() == length) {
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            combination(current + order.charAt(i), order, length, i + 1);
        }
    }
}