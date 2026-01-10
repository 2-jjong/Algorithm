import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // 1. 돗자리 크기를 큰 순서대로 정렬
        Arrays.sort(mats);
        
        // 2. 가장 큰 돗자리부터 시도
        for (int m = mats.length - 1; m >= 0; m--) {
            int size = mats[m];
            
            // 공원의 모든 좌표 탐색
            for (int i = 0; i <= park.length - size; i++) {
                for (int j = 0; j <= park[0].length - size; j++) {
                    
                    // 3. 해당 위치에 돗자리를 깔 수 있는지 확인
                    if (isValid(park, i, j, size)) {
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }

    // 돗자리를 놓을 수 있는지 체크하는 함수
    private boolean isValid(String[][] park, int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                // 한 칸이라도 -1이 아니면 못 깔음
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}