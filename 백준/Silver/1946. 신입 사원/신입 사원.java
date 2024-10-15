import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            TestRank[] ranks = new TestRank[N];
            int ans = 0;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                ranks[j] = new TestRank(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(ranks, (o1, o2) -> Integer.compare(o1.documentRank, o2.documentRank));
            ans++;
            int interviewMinRank = ranks[0].interviewRank;

            for (int k = 1; k < N; k++) {
                if (interviewMinRank > ranks[k].interviewRank) {
                    ans++;
                    interviewMinRank = ranks[k].interviewRank;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static class TestRank {
        int documentRank;
        int interviewRank;

        public TestRank(int documentRank, int interviewRank) {
            this.documentRank = documentRank;
            this.interviewRank = interviewRank;
        }
    }
}