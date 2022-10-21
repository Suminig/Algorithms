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
		String L = st.nextToken();
		String R = st.nextToken();
		int cnt = 0;

		if (L.length() == R.length()) {
			for (int i = 0; i < L.length(); i++) {
				if (L.charAt(i) == R.charAt(i) && L.charAt(i) == '8')
					cnt++;
				else if (L.charAt(i) != R.charAt(i))
					break;
			}
		}

		sb.append(cnt);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}