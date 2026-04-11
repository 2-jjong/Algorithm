import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        N = Integer.parseInt(line);

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        solve(0, "");
        
        System.out.print(sb.toString());
    }

    static void solve(int depth, String underbar) {
        sb.append(underbar).append("\"재귀함수가 뭔가요?\"").append("\n");

        if (depth == N) {
            sb.append(underbar).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
            sb.append(underbar).append("라고 답변하였지.").append("\n"); 
            return;
        }

        sb.append(underbar).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
        sb.append(underbar).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
        sb.append(underbar).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");

        solve(depth + 1, underbar + "____");

        sb.append(underbar).append("라고 답변하였지.").append("\n");
    }
}