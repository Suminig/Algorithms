import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static int max(int[] arr) {
		int max = 0;
		for (int x : arr) {
			max = max < x ? x : max;
		}

		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i] < arr[j])
					dp[j] = Math.max(dp[j], dp[i] + 1);
			}
		}

		sb.append(max(dp));

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}