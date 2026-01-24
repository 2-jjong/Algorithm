import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        // 오름차순 정렬
        Arrays.sort(weights);
        
        // 무게별 인원수를 저장할 배열
        Map<Double, Integer> map = new HashMap<>();

        for (int w : weights) {
            double weight = (double) w;
            
            // 짝꿍이 될 수 있는 비율들 확인
            // 비율 1:1
            if (map.containsKey(weight)) answer += map.get(weight);
            // 비율 2:3
            if (map.containsKey(weight * 2 / 3)) answer += map.get(weight * 2 / 3);
            // 비율 2:4
            if (map.containsKey(weight * 2 / 4)) answer += map.get(weight * 2 / 4);
            // 비율 3:4
            if (map.containsKey(weight * 3 / 4)) answer += map.get(weight * 3 / 4);
            
            // 현재 무게 카운트 증가
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
        
        return answer;
    }
}