import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int matchCount = 0;
        int zeroCount = 0;

        Set<Integer> winSet = new HashSet<>();
        for (int num : win_nums)
            winSet.add(num);

        for (int num : lottos) {
            if (num == 0)
                zeroCount++;
            else if (winSet.contains(num))
                matchCount++;
        }

        int maxMatch = matchCount + zeroCount;
        int minMatch = matchCount;

        return new int[]{getRank(maxMatch), getRank(minMatch)};
    }

    public int getRank(int count) {
        if (count == 6)
            return 1;
        if (count == 5)
            return 2;
        if (count == 4)
            return 3;
        if (count == 3)
            return 4;
        if (count == 2)
            return 5;
        
        return 6;
    }
}