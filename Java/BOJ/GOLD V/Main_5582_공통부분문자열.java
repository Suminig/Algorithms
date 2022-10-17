import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String str1 = in.readLine();
		String str2 = in.readLine();

		int len1 = str1.length();
		int len2 = str2.length();

		int[][] dp = new int[len1 + 1][len2 + 1];
		int lcs = 0;

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					lcs = lcs < dp[i][j] ? dp[i][j] : lcs;
				}
			}
		}

		sb.append(lcs);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}