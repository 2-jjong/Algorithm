import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr1 = new int[n];
			int[] arr2 = new int[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			int max = Integer.MIN_VALUE;

			if (n > m)
				max = getMaxProductSum(arr2, arr1);
			else
				max = getMaxProductSum(arr1, arr2);

			sb.append("#").append(testCase + 1).append(" ").append(max).append("\n");

		}

		System.out.println(sb);

	}

	private static int getMaxProductSum(int[] shortArr, int[] longArr) {
		int maxSum = Integer.MIN_VALUE;
		int shortLen = shortArr.length;
		int longLen = longArr.length;

		for (int i = 0; i <= longLen - shortLen; i++) {
			int currentSum = 0;
			for (int j = 0; j < shortLen; j++) {
				currentSum += shortArr[j] * longArr[i + j];
			}
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}

}