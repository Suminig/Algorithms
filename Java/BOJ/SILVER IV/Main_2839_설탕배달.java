import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		int ans = 0;

		while (N >= 0) {
			if (N % 5 == 0) {
				ans += N / 5;
				N = N % 5;
				break;
			}
			ans += 1;
			N -= 3;
		}

		if (N == 0) {
			sb.append(ans);
		} else {
			sb.append(-1);
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}