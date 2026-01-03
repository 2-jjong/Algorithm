import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. 모든 전화번호를 맵에 저장
        Map<String, Integer> map = new HashMap<>();
        for (String number : phone_book) {
            map.put(number, 1);
        }

        // 2. 각 번호의 부분 문자열이 맵에 존재하는지 확인
        for (String number : phone_book) {
            for (int j = 1; j < number.length(); j++) {
                // 번호를 앞에서부터 한 글자씩 늘려가며 확인
                if (map.containsKey(number.substring(0, j))) {
                    return false; // 접두어가 존재하면 false 반환
                }
            }
        }

        return true; // 끝까지 없으면 true 반환
    }
}