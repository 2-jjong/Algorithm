import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visitedPaths = new HashSet<>();

        int x = 0;
        int y = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char command = dirs.charAt(i);
            int nextX = x;
            int nextY = y;

            if (command == 'U')
                nextY++;
            else if (command == 'D')
                nextY--;
            else if (command == 'R')
                nextX++;
            else if (command == 'L')
                nextX--;

            if (nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) {
                continue; 
            }

            String path1 = x + "" + y + "" + nextX + "" + nextY;
            String path2 = nextX + "" + nextY + "" + x + "" + y;

            if (path1.compareTo(path2) < 0) {
                visitedPaths.add(path1);
            } else {
                visitedPaths.add(path2);
            }

            x = nextX;
            y = nextY;
        }

        return visitedPaths.size();
    }
}