import java.util.*;

class Solution {
    static class Song implements Comparable<Song> {
        int id;
        int plays;

        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }

        @Override
        public int compareTo(Song other) {
            if (this.plays != other.plays) {
                return Integer.compare(other.plays, this.plays);
            }
            return Integer.compare(this.id, other.id);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalPlay = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreTotalPlay.put(genre, genreTotalPlay.getOrDefault(genre, 0) + play);

            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>())
                      .add(new Song(i, play));
        }

        List<String> sortedGenres = new ArrayList<>(genreTotalPlay.keySet());
        sortedGenres.sort((a, b) -> Integer.compare(genreTotalPlay.get(b), genreTotalPlay.get(a)));

        List<Integer> bestAlbum = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);
            Collections.sort(songs);

            int limit = Math.min(2, songs.size());
            for (int i = 0; i < limit; i++) {
                bestAlbum.add(songs.get(i).id);
            }
        }

        int[] answer = new int[bestAlbum.size()];
        for (int i = 0; i < bestAlbum.size(); i++) {
            answer[i] = bestAlbum.get(i);
        }

        return answer;
    }
}