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

		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] leak = new int[1001];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			leak[Integer.parseInt(st.nextToken())] = 1;
		}

		int res = 0;
		for (int i = 1; i <= 1000; i++) {
			if (leak[i] != 0) {
				if (i + L - 1 >= 1000) {
					res++;
					break;
				}

				i += L - 1;
				res++;
			}
		}

		sb.append(res);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}