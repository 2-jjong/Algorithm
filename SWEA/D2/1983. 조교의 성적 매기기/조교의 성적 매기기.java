import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		String[] grades = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

		for (int testCase = 0; testCase < t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken()) - 1;
			Double[] scores = new Double[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				double middleExam = Integer.parseInt(st.nextToken()) * 0.35;
				double finalExam = Integer.parseInt(st.nextToken()) * 0.45;
				double homeWork = Integer.parseInt(st.nextToken()) * 0.2;
				scores[i] = middleExam + finalExam + homeWork;
			}

			double targetScore = scores[k];

			Arrays.sort(scores, Collections.reverseOrder());

			int rank = 0;
			for (int i = 0; i < n; i++) {
				if (scores[i] == targetScore) {
					rank = i;
					break;
				}
			}

			int gradeIndex = rank * 10 / n;
			String result = grades[gradeIndex];

			sb.append("#").append(testCase + 1).append(" ").append(result).append("\n");
		}

		System.out.println(sb);

	}

}