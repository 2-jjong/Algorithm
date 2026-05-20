class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            StringBuilder sb = new StringBuilder();

            // 선행 스킬들만 따로 분류
            for (char ch : skillTree.toCharArray()) {
                if (skill.indexOf(ch) != -1) {
                    sb.append(ch);
                }
            }
            
            String filteredSkill = sb.toString();
            
            if (skill.startsWith(filteredSkill)) {
                answer++;
            }
        }

        return answer;
    }
}