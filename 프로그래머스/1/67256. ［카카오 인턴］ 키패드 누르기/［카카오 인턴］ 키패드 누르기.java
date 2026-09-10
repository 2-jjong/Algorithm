class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int leftPos = 10;
        int rightPos = 12;
        
        for (int num : numbers) {
            if (num == 0) {
                num = 11; 
            }
            
            if (num % 3 == 1) {
                answer.append("L");
                leftPos = num;
            } 
            else if (num % 3 == 0) {
                answer.append("R");
                rightPos = num;
            } 
            else {
                int leftDist = (Math.abs(num - leftPos) / 3) + (Math.abs(num - leftPos) % 3);
                int rightDist = (Math.abs(num - rightPos) / 3) + (Math.abs(num - rightPos) % 3);
                
                if (leftDist < rightDist) {
                    answer.append("L");
                    leftPos = num;
                } else if (leftDist > rightDist) {
                    answer.append("R");
                    rightPos = num;
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftPos = num;
                    } else {
                        answer.append("R");
                        rightPos = num;
                    }
                }
            }
        }
        
        return answer.toString();
    }
}