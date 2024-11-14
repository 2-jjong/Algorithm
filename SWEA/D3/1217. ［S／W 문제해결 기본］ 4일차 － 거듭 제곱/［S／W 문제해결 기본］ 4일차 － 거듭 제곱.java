import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		Scanner sc = new Scanner(System.in);

		for (int testCase = 1; testCase <= 10; testCase++) {
			int t = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();

			System.out.println("#" + t + " " + pow(n, m));
		}
	}

	public static int pow(int n, int m) {
		if (m == 1)
			return n;

		return n * pow(n, m - 1);
	}

}