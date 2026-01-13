class Solution {
    public String solution(String X, String Y) {
        // 1. 각 숫자의 개수를 저장
        int[] xCounts = new int[10];
        int[] yCounts = new int[10];

        // X의 숫자 개수 세기
        for (String s : X.split("")) {
            xCounts[Integer.parseInt(s)]++;
        }
        // Y의 숫자 개수 세기
        for (String s : Y.split("")) {
            yCounts[Integer.parseInt(s)]++;
        }

        // 2. 개수가 같은 숫자들 추출
        StringBuilder sb = new StringBuilder();

        // 가장 큰 수를 만들어야 하므로 9부터 0까지 거꾸로 확인
        for (int i = 9; i >= 0; i--) {
            // X와 Y에 공통으로 포함된 개수만큼 추가
            int commonCount = Math.min(xCounts[i], yCounts[i]);
            for (int j = 0; j < commonCount; j++) {
                sb.append(i);
            }
        }

        // 3. 예외 상황 처리
        String answer = sb.toString();
        
        if (answer.isEmpty()) return "-1"; // 짝꿍이 없는 경우 -1 반환
        if (answer.startsWith("0")) return "0"; // 0으로 시작하면 가장 큰 수가 0이므로 0으로 반환

        return answer;
    }
}