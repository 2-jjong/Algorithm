import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());

		if (minute >= 45)
			sb.append(hour).append(" ").append(minute - 45);
		else if (hour == 0)
			sb.append(23).append(" ").append(minute + 60 - 45);
		else
			sb.append(hour - 1).append(" ").append(minute + 60 - 45);

		System.out.println(sb);

	}

}