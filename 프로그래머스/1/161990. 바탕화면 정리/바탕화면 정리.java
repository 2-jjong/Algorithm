class Solution {
    public int[] solution(String[] wallpaper) {
        // 최소 좌표는 가장 큰 값으로, 최대 좌표는 가장 작은 값으로 초기화
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        // 1. 바탕화면 전체를 순회하며 파일('#')의 위치를 찾는다
        for (int r = 0; r < wallpaper.length; r++) {
            for (int c = 0; c < wallpaper[r].length(); c++) {
                if (wallpaper[r].charAt(c) == '#') {
                    // 2. 파일이 있다면 현재까지의 최소/최대 좌표를 갱신한다.
                    minX = Math.min(minX, r);
                    minY = Math.min(minY, c);
                    maxX = Math.max(maxX, r);
                    maxY = Math.max(maxY, c);
                }
            }
        }
        
        // 3. 드래그의 끝점은 파일이 있는 칸의 오른쪽 아래이므로 +1을 해준다.
        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }
}