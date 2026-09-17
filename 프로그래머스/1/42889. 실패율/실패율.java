import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    class Stage implements Comparable<Stage> {
        int id;
        double failureRate;

        public Stage(int id, double failureRate) {
            this.id = id;
            this.failureRate = failureRate;
        }

        @Override
        public int compareTo(Stage o) {
            if (this.failureRate == o.failureRate) {
                return Integer.compare(this.id, o.id);
            }
            return Double.compare(o.failureRate, this.failureRate);
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] stageCounts = new int[N + 2];
        for (int stage : stages) {
            stageCounts[stage]++;
        }

        List<Stage> stageList = new ArrayList<>();
        double totalPlayers = stages.length; 

        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                stageList.add(new Stage(i, 0));
            } else {
                double failureRate = stageCounts[i] / totalPlayers;
                stageList.add(new Stage(i, failureRate));
                
                totalPlayers -= stageCounts[i];
            }
        }

        Collections.sort(stageList);

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).id;
        }

        return answer;
    }
}