import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        // 1. 첫 번째 숫자는 배열 원소 0~9와 중복이 되지 않는 -1로 초기화
        int lastNum = -1;
        
        for (int num : arr) {
            // 2. 현재 숫자(num)가 방금 넣은 숫자(lastNum)와 다를 때만 리스트에 추가
            if (num != lastNum) {
                list.add(num);
                lastNum = num;
            }
        }
        
        // 3. 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}