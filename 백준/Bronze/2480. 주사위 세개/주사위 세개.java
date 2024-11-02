import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dice1 = Integer.parseInt(st.nextToken());
		int dice2 = Integer.parseInt(st.nextToken());
		int dice3 = Integer.parseInt(st.nextToken());
		int result = 0;

		if (dice1 == dice2 && dice2 == dice3) {
			result = 10000 + dice1 * 1000;
		} else if (dice1 == dice2) {
			result = 1000 + dice1 * 100;
		} else if (dice2 == dice3) {
			result = 1000 + dice2 * 100;
		} else if (dice1 == dice3) {
			result = 1000 + dice1 * 100;
		} else {
			int maxDice = Math.max(dice1, Math.max(dice2, dice3));
			result = maxDice * 100;
		}

		System.out.println(result);

	}

}