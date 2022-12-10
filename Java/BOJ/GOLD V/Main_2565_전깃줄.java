import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Line implements Comparable<Line> {
		int A, B;

		public Line(int A, int B) {
			this.A = A;
			this.B = B;
		}

		@Override
		public int compareTo(Line o) {
			return this.A - o.A;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());

		Line[] lines = new Line[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			lines[i] = new Line(A, B);
		}

		Arrays.sort(lines);

		int[] dp = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (lines[i].B > lines[j].B) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}

		sb.append(N - max);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}