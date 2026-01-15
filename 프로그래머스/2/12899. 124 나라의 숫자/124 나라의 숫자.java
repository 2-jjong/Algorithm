class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        // 1, 2, 4를 나머지에 매핑 (0일 때 4, 1일 때 1, 2일 때 2)
        String[] numbers = {"4", "1", "2"};
        
        while (n > 0) {
            int remainder = n % 3; // 3으로 나눈 나머지
            sb.append(numbers[remainder]); // 나머지에 해당하는 숫자 추가
            
            // 나머지가 0일 때는 몫을 1 줄임
            if (remainder == 0) {
                n = (n / 3) - 1;
            } else {
                n = n / 3;
            }
        }
        
        // 결과 반환
        return sb.reverse().toString();
    }
}