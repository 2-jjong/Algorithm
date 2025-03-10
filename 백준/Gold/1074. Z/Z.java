import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, r, c;
	private static int size;

	public static int find(int currentSize, int currentX, int currentY) {

		if (currentSize == 1) {
			return 0;
		}

		currentSize /= 2;

		if (currentX < currentSize && currentY < currentSize) {
			return find(currentSize, currentX, currentY);
		}

		else if (currentX < currentSize && currentY >= currentSize) {
			return currentSize * currentSize * 1 + find(currentSize, currentX, currentY - currentSize);
		}

		else if (currentX >= currentSize && currentY < currentSize) {
			return currentSize * currentSize * 2 + find(currentSize, currentX - currentSize, currentY);
		}

		else {
			return currentSize * currentSize * 3 + find(currentSize, currentX - currentSize, currentY - currentSize);
		}

	}

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);

		/**
		 * 2. 알고리즘 풀기
		 */

		int answer = find(size, r, c);

		/**
		 * 3. 정답 출력
		 */

		sb.append(answer).append("\n");

		System.out.println(sb);
	}

}