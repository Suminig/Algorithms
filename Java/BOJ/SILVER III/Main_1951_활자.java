import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static final int mod = 1234567;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		long N = Integer.parseInt(in.readLine());
		int M = String.valueOf(N).length();
		long ans = 0;

		for (int i = 1; i < M; i++) {
			ans += ((Math.pow(10, i) - Math.pow(10, i - 1)) * i) % mod;
		}
		
		ans += ((N - Math.pow(10, M - 1) + 1) * M) % mod;
		
		sb.append(ans % mod);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}