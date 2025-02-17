import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {
		/**
		 * 0. 입력파일 읽어들이기
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			// 알고리즘 코드 작성하기
			/**
			 * 1. 입력 파일 객체화
			 */
			int dumpCount = Integer.parseInt(in.readLine());
			String[] tempArr = in.readLine().split(" ");
			int[] boxes = new int[100];

			for (int i = 0; i < boxes.length; i++) {
				boxes[i] = Integer.parseInt(tempArr[i]);
			}

			/**
			 * 2. 알고리즘 풀기
			 */

			int result = -1;

			for (int i = 0; i < dumpCount; i++) {
				int minIndex = 0;
				int maxIndex = 0;

				for (int j = 1; j < boxes.length; j++) {
					if (boxes[minIndex] > boxes[j])
						minIndex = j;

					if (boxes[maxIndex] < boxes[j])
						maxIndex = j;
				}

				// 가장 큰 높이의 작은 높이의 차이가 0 또는 1이면 break;
				if (boxes[maxIndex] - boxes[minIndex] <= 1) {
					result = boxes[maxIndex] - boxes[minIndex];
					break;
				}

				// dump
				boxes[minIndex]++;
				boxes[maxIndex]--;
			}
			
			int min = boxes[0];
			int max = boxes[0];
			for (int i = 1; i < boxes.length; i++) {
			    if (min > boxes[i]) min = boxes[i];
			    if (max < boxes[i]) max = boxes[i];
			}
			result = max - min;

			/**
			 * 3. 정답 출력
			 */
			sb.append(result).append("\n");
		}

		System.out.println(sb);

	}

}