import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int value = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                map.put(value, map.getOrDefault(value, 0) + 1);
            } else if (!map.isEmpty()) {
                int targetKey = (value == 1) ? map.lastKey() : map.firstKey();

                if (map.get(targetKey) == 1) {
                    map.remove(targetKey);
                } else {
                    map.put(targetKey, map.get(targetKey) - 1);
                }
            }
        }

        if (map.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{map.lastKey(), map.firstKey()};
    }
}