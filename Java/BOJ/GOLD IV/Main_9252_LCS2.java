import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String word1 = in.readLine();
		String word2 = in.readLine();

		int len1 = word1.length();
		int len2 = word2.length();

		int[][] dp = new int[len1 + 1][len2 + 1];
		int cnt = 0;

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				char c1 = word1.charAt(i - 1);
				char c2 = word2.charAt(j - 1);

				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					if (dp[i][j - 1] > dp[i - 1][j])
						dp[i][j] = dp[i][j - 1];
					else
						dp[i][j] = dp[i - 1][j];
				}

				cnt = cnt < dp[i][j] ? dp[i][j] : cnt;
			}
		}

		StringBuilder lcs = new StringBuilder();
		while (len1 > 0 && len2 > 0) {
			if (dp[len1 - 1][len2] == dp[len1][len2]) {
				len1--;
			} else if (dp[len1][len2 - 1] == dp[len1][len2]) {
				len2--;
			} else {
				lcs.append(word1.charAt(len1 - 1));
				len1--;
				len2--;
			}
		}

		sb.append(cnt).append("\n");
		sb.append(lcs.reverse().toString());

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}