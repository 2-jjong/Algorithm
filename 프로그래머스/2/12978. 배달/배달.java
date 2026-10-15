import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    class Node implements Comparable<Node> {
        int to;
        int weight;
        
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            int u = r[0];
            int v = r[1];
            int w = r[2];
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (dist[current.to] < current.weight) {
                continue;
            }
            
            for (Node next : graph.get(current.to)) {
                int cost = dist[current.to] + next.weight;
                
                if (cost < dist[next.to]) {
                    dist[next.to] = cost;
                    pq.offer(new Node(next.to, cost));
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}