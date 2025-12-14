class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            if (isValidSchedule(schedules[i], timelogs[i], startday)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isValidSchedule(int schedule, int[] timelog, int startday) {
        int deadline = addMinutes(schedule, 10);
        int currentDay = startday;
        
        for (int time : timelog) {
            // 평일(월~금, 1~5)만 체크
            if (currentDay >= 1 && currentDay <= 5) {
                if (time > deadline) {
                    return false;
                }
            }
            
            // 다음 날로 이동
            currentDay = (currentDay % 7) + 1;
        }
        
        return true;
    }
    
    private int addMinutes(int time, int minutesToAdd) {
        int hour = time / 100;
        int minute = time % 100;
        
        minute += minutesToAdd;
        
        if (minute >= 60) {
            hour += minute / 60;
            minute %= 60;
        }
        
        return hour * 100 + minute;
    }
}