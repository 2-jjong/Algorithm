import java.util.*;

class Solution {
    int answer = 0;
    int N;
    int[][] Q;
    int[] ANS;

    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        Q = q;
        ANS = ans;
        
        // 5개의 숫자를 뽑는 조합 탐색
        combine(1, 0, new int[5]);
        
        return answer;
    }

    private void combine(int start, int depth, int[] selected) {
        // 5개의 숫자를 모두 뽑았을 때
        if (depth == 5) {
            if (check(selected)) {
                answer++;
            }
            return;
        }

        // 조합 생성
        for (int i = start; i <= N; i++) {
            selected[depth] = i;
            combine(i + 1, depth + 1, selected);
        }
    }

    private boolean check(int[] selected) {
        // 모든 질문(q)에 대해 조건을 만족하는지 확인
        for (int i = 0; i < Q.length; i++) {
            int count = 0;
            
            // 현재 선택된 5개의 숫자와 질문의 5개 숫자를 비교
            for (int sNum : selected) {
                for (int qNum : Q[i]) {
                    if (sNum == qNum) {
                        count++;
                        break;
                    }
                }
            }
            
            // 겹치는 개수가 문제의 답변(ans)과 다르면 실패
            if (count != ANS[i]) {
                return false;
            }
        }
        return true;
    }
}