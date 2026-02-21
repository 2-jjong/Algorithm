import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] board;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[depth] = i; // depth행 i열에 퀸 놓기
            
            // 놓을 수 있는 위치라면 다음 진행
            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            // 같은 열에 퀸이 있는지 확인
            if (board[col] == board[i]) {
                return false;
            }
            
            // 대각선에 퀸이 있는지 확인
            if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }
        return true;
    }
}