import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<String> columns = Arrays.asList("code", "date", "maximum", "remain");
        
        int extIndex = columns.indexOf(ext);
        int sortByIndex = columns.indexOf(sort_by);
        
        List<int[]> filteredList = new ArrayList<>();
        
        for (int[] row : data) {
            if (row[extIndex] < val_ext) {
                filteredList.add(row);
            }
        }
        
        filteredList.sort(Comparator.comparingInt(o -> o[sortByIndex]));
        
        int[][] answer = new int[filteredList.size()][4];
        for (int i = 0; i < filteredList.size(); i++) {
            answer[i] = filteredList.get(i);
        }
        
        return answer;
    }
}