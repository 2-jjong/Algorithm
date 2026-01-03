import java.util.*;

class Solution {
    HashSet<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        
        // 1. 모든 숫자 조합 만들기
        makeNumbers("", numbers);
        
        // 2. 소수 개수 세기
        for (int num : numberSet) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }

    // 숫자를 조합하는 재귀 함수
    private void makeNumbers(String combination, String others) {
        // 현재까지 만든 조합이 비어있지 않다면 숫자로 변환해 셋에 추가
        if (!combination.equals("")) {
            numberSet.add(Integer.parseInt(combination));
        }

        // 남은 숫자들 중에서 하나를 골라 조합에 추가
        for (int i = 0; i < others.length(); i++) {
            makeNumbers(combination + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    // 소수인지 확인하는 함수
    private boolean isPrime(int num) {
        if (num < 2)
            return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        
        return true;
    }
}