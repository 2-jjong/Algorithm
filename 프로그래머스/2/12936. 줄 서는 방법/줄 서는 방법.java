import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        // 사용할 숫자들을 담은 리스트
        List<Integer> list = new ArrayList<>();
        long factorial = 1;
        
        // 초기 팩토리얼 계산 및 리스트 초기화
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i; // n!의 값을 구함
        }
        
        // k를 0부터 시작하는 인덱스로 사용하기 위해 -1
        k--; 
        
        int idx = 0;
        while (idx < n) {
            // 현재 자리를 제외한 나머지 숫자들로 만들 수 있는 순열 개수 계산
            factorial /= (n - idx); 
            
            // 현재 위치에 들어갈 숫자의 인덱스 찾기
            int listIdx = (int) (k / factorial);
            
            // 리스트에서 숫자를 꺼내 정답 배열에 추가
            answer[idx++] = list.get(listIdx);
            list.remove(listIdx); 
            
            // k를 나머지 값으로 갱신
            k %= factorial;
        }
        
        return answer;
    }
}