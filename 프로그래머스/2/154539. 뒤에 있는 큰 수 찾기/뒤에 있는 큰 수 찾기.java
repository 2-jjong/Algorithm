import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // 뒤에서부터
        for (int i = n - 1; i >= 0; i--) {
            // 스택에서 현재 값보다 작거나 같은 값들 제거
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            
            // 스택이 비어있으면 뒷 큰수 없음
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            
            // 현재 값을 스택에 추가
            stack.push(numbers[i]);
        }
        
        return answer;
    }
}