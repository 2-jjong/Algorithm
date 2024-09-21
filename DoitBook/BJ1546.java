import java.util.Scanner;

public class BJ1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Double maxScore = 0.0;

        Double[] arr = new Double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextDouble();

            if (maxScore < arr[i]) {
                maxScore = arr[i];
            }
        }

        Double sum = 0.0;

        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] / maxScore * 100;
            sum += arr[i];
        }

        Double avg = sum / N;

        System.out.println(avg);
    }
}