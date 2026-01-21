import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 인형을 담을 바구니
        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            int col = move - 1;

            // 맨 위부터 인형이 있는지 확인
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != 0) {
                    int doll = board[row][col];
                    board[row][col] = 0;

                    // 바구니 맨 위 인형과 비교
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop(); // 같은 인형이면 터뜨림
                        answer += 2;  // 사라진 인형 개수에 추가
                    } else {
                        basket.push(doll); // 다르면 바구니에 추가
                    }
                    
                    // 다음 move로 넘어감
                    break;
                }
            }
        }

        return answer;
    }
}