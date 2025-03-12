import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int N = 6;
	private static int[] win;
	private static int[] draw;
	private static int[] lose;
    static int[][] matches;
	private static boolean result;

    public static void dfs(int cnt) {
        if(cnt == 15) {
            result = true;
            return;
        }

        int teamA = matches[cnt][0];
        int teamB = matches[cnt][1];

        if(win[teamA] > 0 && lose[teamB] > 0) {
            win[teamA]--;
            lose[teamB]--;
            dfs(cnt+1);
            win[teamA]++;
            lose[teamB]++;
        }

        if(draw[teamA] > 0 && draw[teamB] > 0) {
        	draw[teamA]--;
        	draw[teamB]--;
            dfs(cnt+1);
            draw[teamA]++;
            draw[teamB]++;
        }

        if(lose[teamA] > 0 && win[teamB] > 0) {
            lose[teamA]--;
            win[teamB]--;
            dfs(cnt+1);
            lose[teamA]++;
            win[teamB]++;
        }
    }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        matches = new int[15][2];
        int idx = 0;
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                matches[idx][0] = i;
                matches[idx][1] = j;
                idx++;
            }
        }

		for (int t = 0; t < 4; t++) {
			win = new int[N];
			draw = new int[N];
			lose = new int[N];
			result = false;

			StringTokenizer st = new StringTokenizer(br.readLine());

			boolean valid = true;
			for (int i = 0; i < N; i++) {
				int w = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());

				if (w + d + l != 5)
					valid = false;
				win[i] = w;
				draw[i] = d;
				lose[i] = l;
			}

			if (valid)
				dfs(0);

			sb.append(result ? 1 : 0).append(" ");
		}

		System.out.println(sb);
	}
}