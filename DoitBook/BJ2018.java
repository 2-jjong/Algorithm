import java.util.Scanner;

public class BJ2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        int count = 1;

        while (endIndex < N) {
            if (sum == N) {
                count++;
                endIndex++;
                sum += endIndex;
            } else if (sum < N) {
                endIndex++;
                sum += endIndex;
            } else if (sum > N) {
                sum -= startIndex;
                startIndex++;
            }
        }

        System.out.println(count);
    }
}