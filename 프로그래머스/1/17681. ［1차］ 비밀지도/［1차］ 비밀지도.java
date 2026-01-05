class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // 1. 두 지도를 OR 연산으로 합침
            int combined = arr1[i] | arr2[i];
            
            // 2. 2진수 문자열로 변환
            String binary = Integer.toBinaryString(combined);
            
            // 3. n자리 길이에 맞춰 앞에 0 채우기
            while (binary.length() < n) {
                binary = 0 + binary;
            }
            
            // 4. 1은 #으로, 0은 공백으로 변환
            binary = binary.replace('1', '#');
            binary = binary.replace('0', ' ');
            
            answer[i] = binary;
        }

        return answer;
    }
}