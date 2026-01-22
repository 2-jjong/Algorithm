class Solution {
    public String solution(String new_id) {
        // 1단계: 소문자로 변경
        String answer = new_id.toLowerCase();

        // 2단계: 허용된 문자 제외 제거
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length(); i++) {
            char ch = answer.charAt(i);
            
            if ((ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9') ||
                ch == '-' || ch == '_' || ch == '.') {
                sb.append(ch);
            }
        }
        answer = sb.toString();

        // 3단계: 마침표(.)가 2번 이상 연속되면 하나로 교체
        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

        // 4단계: 처음이나 끝에 있는 마침표 제거
        if (answer.startsWith(".")) {
            answer = answer.substring(1);
        }
        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }

        // 5단계: 빈 문자열이면 "a" 대입
        if (answer.isEmpty()) {
            answer = "a";
        }

        // 6단계: 16자 이상이면 15자만 남기기
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            
            // 자르고 나서 끝에 마침표가 있으면 제거
            if (answer.endsWith(".")) {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        // 7단계: 2자 이하면 마지막 문자 반복
        while (answer.length() <= 2) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}