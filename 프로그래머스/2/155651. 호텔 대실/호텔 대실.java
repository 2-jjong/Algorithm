import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 예약 시간을 분 단위로 변환하여 리스트에 저장
        List<int[]> bookings = new ArrayList<>();
        for (String[] time : book_time) {
            int start = calculateMinutes(time[0]);
            int end = calculateMinutes(time[1]) + 10; 
            bookings.add(new int[]{start, end});
        }

        bookings.sort((a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (int[] bookingTime : bookings) {
            int startTime = bookingTime[0];
            int endTime = bookingTime[1];

            if (!rooms.isEmpty() && rooms.peek() <= startTime) {
                rooms.poll();
            }

            rooms.add(endTime);
        }

        return rooms.size();
    }

    private int calculateMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}