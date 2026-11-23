import java.util.*;

class Solution {
    private Set<Integer> resultSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, 0, user_id, banned_id);
        return resultSet.size();
    }

    private void dfs(int depth, int mask, String[] userIds, String[] bannedIds) {
        if (depth == bannedIds.length) {
            resultSet.add(mask);
            return;
        }

        for (int i = 0; i < userIds.length; i++) {
            if ((mask & (1 << i)) == 0 && isMatch(userIds[i], bannedIds[depth])) {
                dfs(depth + 1, mask | (1 << i), userIds, bannedIds);
            }
        }
    }

    private boolean isMatch(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }

        for (int i = 0; i < user.length(); i++) {
            char bChar = banned.charAt(i);
            if (bChar != '*' && bChar != user.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}