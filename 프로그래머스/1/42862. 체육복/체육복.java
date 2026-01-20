import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 수업에 참여할 수 있는 학생 수
        int count = n - lost.length;
        
        // 여벌 옷이 있는데 도난당한 학생 제외
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    count++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // 옷 빌려주기
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) // 이미 해결된 학생 건너뜀
                continue;

            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == -1) // 이미 빌려준 학생 건너뜀
                    continue;

                // 앞번호나 뒷번호인지 확인
                if (reserve[j] == (lost[i] - 1) || reserve[j] == (lost[i] + 1)) {
                    count++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return count;
    }
}