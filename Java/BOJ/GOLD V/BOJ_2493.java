import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {
			int index = i - 1;
			while (index > 0) {
				if (arr[i] > arr[index]) {
					index = dp[index];
				} else {
					dp[i] = index;
					break;
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			sb.append(dp[i]).append(" ");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}