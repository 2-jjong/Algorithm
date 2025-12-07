class Solution {
    public int[] solution(String[] park, String[] routes) {
        int height = park.length;
        int width = park[0].length();
        
        // 시작 위치 찾기
        int startRow = 0, startCol = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (park[i].charAt(j) == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }
        
        int currentRow = startRow;
        int currentCol = startCol;
        
        // 방향별 이동 벡터
        int[] dirRow = {-1, 1, 0, 0}; // N, S, E, W
        int[] dirCol = {0, 0, 1, -1};
        
        for (String route : routes) {
            String[] parts = route.split(" ");
            char direction = parts[0].charAt(0);
            int distance = Integer.parseInt(parts[1]);
            
            // 방향 결정
            int dirIndex = 0;
            if (direction == 'N') dirIndex = 0;
            else if (direction == 'S') dirIndex = 1;
            else if (direction == 'E') dirIndex = 2;
            else if (direction == 'W') dirIndex = 3;
            
            // 이동 가능 여부 체크
            boolean isValid = true;
            int newRow = currentRow;
            int newCol = currentCol;
            
            for (int step = 1; step <= distance; step++) {
                newRow = currentRow + dirRow[dirIndex] * step;
                newCol = currentCol + dirCol[dirIndex] * step;
                
                // 범위 체크
                if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width) {
                    isValid = false;
                    break;
                }
                
                // 장애물 체크
                if (park[newRow].charAt(newCol) == 'X') {
                    isValid = false;
                    break;
                }
            }
            
            // 이동 가능하면 위치 업데이트
            if (isValid) {
                currentRow = newRow;
                currentCol = newCol;
            }
        }
        
        return new int[] {currentRow, currentCol};
    }
}