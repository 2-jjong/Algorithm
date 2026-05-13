import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, Integer> parking = new HashMap<>();
        Map<String, Integer> times = new TreeMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            int time = calculateTotalMinutes(split[0]);
            String carNum = split[1];
            String type = split[2];

            if (type.equals("IN")) {
                parking.put(carNum, time);
            } else {
                int duration = time - parking.remove(carNum);
                times.put(carNum, times.getOrDefault(carNum, 0) + duration);
            }
        }

        // 출차 기록이 없는 차량 처리
        int lastTime = calculateTotalMinutes("23:59");
        for (String carNum : parking.keySet()) {
            int duration = lastTime - parking.get(carNum);
            times.put(carNum, times.getOrDefault(carNum, 0) + duration);
        }

        // 요금 계산
        int[] answer = new int[times.size()];
        int idx = 0;
        for (String carNum : times.keySet()) {
            int totalTime = times.get(carNum);
            int fee = baseFee;

            if (totalTime > baseTime) {
                fee += Math.ceil((double) (totalTime - baseTime) / unitTime) * unitFee;
            }
            answer[idx++] = fee;
        }

        return answer;
    }

    private int calculateTotalMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}