import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int maxResult = Integer.MIN_VALUE;
    static List<Integer> nums = new ArrayList<>();
    static List<Character> ops = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        // 숫자와 연산자 리스트에 담기
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0)
                nums.add(line.charAt(i) - '0');
            else
                ops.add(line.charAt(i));
        }

        dfs(0, nums.get(0));
        
        System.out.println(maxResult);
    }

    static void dfs(int opIdx, int currentValue) {
        if (opIdx >= ops.size()) {
            maxResult = Math.max(maxResult, currentValue);
            return;
        }

        // 괄호 없이 바로 계산하기
        int result1 = calculate(currentValue, ops.get(opIdx), nums.get(opIdx + 1));
        dfs(opIdx + 1, result1);

        // 괄호 쳐서 계산하기
        if (opIdx + 1 < ops.size()) {
            // (다음 숫자) [다음 연산자] (다다음 숫자)
            int nextResult = calculate(nums.get(opIdx + 1), ops.get(opIdx + 1), nums.get(opIdx + 2));
            
            // (현재까지 결과) [현재 연산자] (nextResult)
            int result2 = calculate(currentValue, ops.get(opIdx), nextResult);
            
            dfs(opIdx + 2, result2);
        }
    }

    static int calculate(int a, char op, int b) {
        if (op == '+')
            return a + b;
        else if (op == '-')
            return a - b;
        else // op == '*'
            return a * b;
    }
}