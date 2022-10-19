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

		boolean[] primes = new boolean[123456 * 2 + 1];
		for (int i = 2; i <= 123456 * 2; i++) {
			primes[i] = true;
		}

		for (int i = 2; (i * i) <= 123456 * 2; i++) {
			if (primes[i]) {
				for (int j = i * i; j <= 123456 * 2; j += i) {
					primes[j] = false;
				}
			}
		}

		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;

			int cnt = 0;
			for (int i = N + 1; i <= 2 * N; i++) {
				if (primes[i])
					cnt++;
			}

			sb.append(cnt).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}