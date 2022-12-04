import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static final int mod = 1_000_000_007;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static long ans(long num, long m) {
		return m * multiply(num, mod - 2) % mod;
	}

	public static long multiply(long num, long m) {
		if (m == 1)
			return num % mod;

		if (m % 2 == 0) {
			long temp = multiply(num, m / 2);
			return (temp * temp) % mod;
		} else {
			return num * multiply(num, m - 1) % mod;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		long res = 0;

		int M = Integer.parseInt(in.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			res += ans(N, S) % mod;
		}

		sb.append(res % mod);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}