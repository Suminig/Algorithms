import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	private static StringTokenizer st;
	private static Long[] fact;
	private static StringBuilder sb = new StringBuilder();
	private static final long p = 1234567891;

	public static long pow(long a, long b) {
		if (b == 0)
			return 1;
		else if (b == 1)
			return a;

		if (b % 2 == 0) {
			long temp = pow(a, b / 2);
			return (temp * temp) % p;
		}

		long temp = pow(a, b - 1) % p;
		return (temp * a) % p;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		fact = new Long[1000001];
		fact[0] = (long) 1;
		for (int i = 1; i < 1000001; i++) {
			fact[i] = fact[i - 1] * i;
			fact[i] %= p;
		}

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long ncr = (fact[N] * (pow((fact[N - R] * fact[R]) % p, p - 2)) % p);
			sb.append(ncr).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}