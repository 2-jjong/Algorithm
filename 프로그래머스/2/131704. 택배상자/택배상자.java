import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        // 보조 컨테이너 벨트
        Stack<Integer> subBelt = new Stack<>();
        
        int currentBox = 1;
        int targetIdx = 0;

        while (currentBox <= order.length) {
            // 일단 보조 벨트에 넣고 확인
            subBelt.push(currentBox);
            
            // 보조 벨트의 맨 위 상자가 지금 실어야 하는 상자인지 확인
            while (!subBelt.isEmpty() && subBelt.peek() == order[targetIdx]) {
                subBelt.pop();     // 트럭에 실음
                answer++;          // 실은 개수 증가
                targetIdx++;       // 다음 목표 상자 인덱스 추가
            }
            
            currentBox++;
        }

        return answer;
    }
}