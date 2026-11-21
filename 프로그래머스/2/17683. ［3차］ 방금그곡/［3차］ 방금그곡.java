class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = -1;
        String targetMelody = normalize(m);

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            int playTime = toMinute(parts[1]) - toMinute(parts[0]);
            String title = parts[2];
            String sheet = normalize(parts[3]);

            String playedMelody = buildPlayedMelody(sheet, playTime);

            if (playedMelody.contains(targetMelody) && playTime > maxPlayTime) {
                maxPlayTime = playTime;
                answer = title;
            }
        }

        return answer;
    }

    private String normalize(String melody) {
        return melody.replace("C#", "c")
                     .replace("D#", "d")
                     .replace("F#", "f")
                     .replace("G#", "g")
                     .replace("A#", "a")
                     .replace("B#", "b")
                     .replace("E#", "e");
    }

    private int toMinute(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private String buildPlayedMelody(String sheet, int playTime) {
        StringBuilder sb = new StringBuilder(playTime);
        int len = sheet.length();

        for (int i = 0; i < playTime; i++) {
            sb.append(sheet.charAt(i % len));
        }

        return sb.toString();
    }
}