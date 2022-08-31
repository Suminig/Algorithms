import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int min;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();

		min = Integer.MAX_VALUE;
		int diff = B.length() - A.length();
		for (int i = 0; i <= diff; i++) {
			int cnt = 0;
			for (int j = 0; j < A.length(); j++) {
				if (A.charAt(j) != B.charAt(i + j))
					cnt++;
			}
			min = Math.min(min, cnt);
		}

		sb.append(min);
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}