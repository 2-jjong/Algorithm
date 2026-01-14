class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 1. 모든 시간을 초 단위로 변환
        int totalLen = toSecond(video_len);
        int currentPos = toSecond(pos);
        int opStart = toSecond(op_start);
        int opEnd = toSecond(op_end);

        // 2. 오프닝 구간 체크
        if (currentPos >= opStart && currentPos <= opEnd) {
            currentPos = opEnd;
        }

        // 3. 명령어 수행
        for (String cmd : commands) {
            if (cmd.equals("next")) {
                currentPos += 10;
                if (currentPos > totalLen) currentPos = totalLen; // 전체 길이 초과 방지
            } else if (cmd.equals("prev")) {
                currentPos -= 10;
                if (currentPos < 0) currentPos = 0; // 0초 미만 방지
            }

            // 오프닝 구간 체크
            if (currentPos >= opStart && currentPos <= opEnd) {
                currentPos = opEnd;
            }
        }

        // 4. 결과를 mm:ss 형식으로 변환
        return String.format("%02d:%02d", currentPos / 60, currentPos % 60);
    }

    // mm:ss -> s 변환 함수
    private int toSecond(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}