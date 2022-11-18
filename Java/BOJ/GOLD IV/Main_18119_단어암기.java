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

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int mem = (1 << 27) - 1;

		int[] words = new int[N];
		for (int i = 0; i < N; i++) {
			String word = in.readLine();
			for (char c : word.toCharArray()) {
				words[i] |= 1 << (c - 'a');
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int cmd = Integer.parseInt(st.nextToken());
			int c = st.nextToken().charAt(0) - 'a';

			if (cmd == 1)
				mem &= ~(1 << c);
			else
				mem |= 1 << c;

			int cnt = 0;
			for (int word : words) {
				if ((word & mem) >= word)
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