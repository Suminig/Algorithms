import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(in.readLine());
			boolean isValid = true;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				if (isValid) {
					if (st.countTokens() == 4) {
						st.nextToken();
						char cur = st.nextToken().charAt(0);
						if (cur - '0' <= 9 && cur - '0' >= 0)
							isValid = false;
					} else {
						st.nextToken();
						char cur = st.nextToken().charAt(0);
						if (!(cur - '0' <= 9 && cur - '0' >= 0))
							isValid = false;
					}
				} else {
					continue;
				}
			}
			sb.append("#").append(tc).append(" ").append(isValid ? 1 : 0).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}