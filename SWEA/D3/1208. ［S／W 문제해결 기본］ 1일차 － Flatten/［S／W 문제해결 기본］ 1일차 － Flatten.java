import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\user\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[] box = new int[100];
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n; i++) {
				dump(box);
			}
			Arrays.sort(box);
			int answer = box[99] - box[0];

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}

		System.out.print(sb);
	}

	public static void dump(int[] box) {
		int minIndex = 0;
		int maxIndex = 0;

		for (int i = 1; i < box.length; i++) {
			if (box[minIndex] > box[i])
				minIndex = i;

			if (box[maxIndex] < box[i])
				maxIndex = i;
		}

		box[minIndex]++;
		box[maxIndex]--;
	}

}