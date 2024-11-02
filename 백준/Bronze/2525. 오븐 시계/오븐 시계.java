import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		int cookMinute = Integer.parseInt(br.readLine());
		int result = hour * 60 + minute;

		result += cookMinute;

		sb.append((result % 1440) / 60).append(" ").append((result % 1440) % 60);

		System.out.println(sb);

	}

}