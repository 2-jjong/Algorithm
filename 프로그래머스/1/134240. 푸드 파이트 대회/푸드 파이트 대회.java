class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        // 1. 왼쪽 선수가 먹을 음식 배치
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2; // 한쪽 선수가 먹을 개수
            
            // 개수만큼 음식 번호를 추가
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }

        // 2. 왼쪽 음식 조합을 저장해두고 물(0) 추가
        String leftSide = sb.toString();
        sb.append("0");

        // 3. 오른쪽 선수는 왼쪽 음식을 거꾸로 먹음
        StringBuilder rightSide = new StringBuilder(leftSide);
        sb.append(rightSide.reverse());

        return sb.toString();
    }
}