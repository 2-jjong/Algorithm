import java.util.ArrayList;
import java.util.List;

class Solution {
    List<int[]> moves = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }
        return answer;
    }

    private void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            moves.add(new int[]{start, end});
            return;
        }
        
        hanoi(n - 1, start, end, mid);
        moves.add(new int[]{start, end});
        hanoi(n - 1, mid, start, end);
    }
}