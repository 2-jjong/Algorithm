import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static List<Integer> search(char[] T, char[] P) {
		List<Integer> matches = new ArrayList<>();

		if (P.length == 0)
			return matches;

		int[] failure = computeFailure(P);
		int j = 0;

		for (int i = 0; i < T.length; i++) {
			while (j > 0 && T[i] != P[j])
				j = failure[j - 1];

			if (T[i] == P[j]) {
				if (j == P.length - 1) {
					matches.add(i - (P.length - 1) + 1);
					j = failure[j];
				} else {
					j++;
				}
			}
		}

		return matches;
	}

	public static int[] computeFailure(char[] P) {
		int[] failure = new int[P.length];
		int j = 0;

		for (int i = 1; i < P.length; i++) {
			while (j > 0 && P[i] != P[j])
				j = failure[j - 1];

			if (P[i] == P[j])
				failure[i] = ++j;
			else
				failure[i] = 0;
		}

		return failure;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();

		List<Integer> result = search(T, P);
		sb.append(result.size()).append("\n");

		for (int pos : result) {
			sb.append(pos).append(" ");
		}

		System.out.println(sb);
	}
}