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

		int ans = 0;
		st = new StringTokenizer(in.readLine(), "-");
		String first = st.nextToken();
		StringTokenizer firstSt = new StringTokenizer(first, "+");
		while (firstSt.hasMoreElements()) {
			ans += Integer.parseInt(firstSt.nextToken());
		}
		
		while (st.hasMoreElements()) {
			StringTokenizer others = new StringTokenizer(st.nextToken(), "+");
			while (others.hasMoreElements()) {
				ans -= Integer.parseInt(others.nextToken());
			}
		}
		
		sb.append(ans);
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}