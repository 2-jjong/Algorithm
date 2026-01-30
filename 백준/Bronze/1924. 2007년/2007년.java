import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken()); // 월
        int y = Integer.parseInt(st.nextToken()); // 일

        // 각 달의 일수
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 요일 배열
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int totalDays = 0;

        // x-1월까지의 모든 일수를 더함
        for (int i = 1; i < x; i++) {
            totalDays += months[i];
        }

        // 이번 달의 일수를 더함
        totalDays += y;

        // 7로 나눈 나머지로 요일 계산
        System.out.println(days[totalDays % 7]);
    }
}