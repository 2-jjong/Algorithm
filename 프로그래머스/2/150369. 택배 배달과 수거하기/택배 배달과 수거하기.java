class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 현재 트럭이 감당할 수 있는 여유 배달/수거량
        int deliveryCapacity = 0;
        int pickupCapacity = 0;
        
        // 가장 멀리 있는 집부터 거꾸로 확인
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 0;
            
            // 현재 집(i)에 배달하거나 수거할 물량이 남아있는 동안 반복
            while (deliveries[i] > deliveryCapacity || pickups[i] > pickupCapacity) {
                cnt++;
                
                // 한 번 방문할 때마다 트럭 용량만큼 채움
                deliveryCapacity += cap;
                pickupCapacity += cap;
            }
            
            // 이번 집의 물량을 처리 (남은 용량 업데이트)
            deliveryCapacity -= deliveries[i];
            pickupCapacity -= pickups[i];
            
            // 방문 횟수만큼 거리 추가
            answer += (i + 1) * cnt * 2;
        }
        
        return answer;
    }
}