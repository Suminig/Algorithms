import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] dp_zero = new int[41];
		dp_zero[0] = 1;
		dp_zero[1] = 0;
		int[] dp_one = new int[41];
		dp_one[0] = 0;
		dp_one[1] = 1;
		for (int i = 2; i < 41; i++) {
			dp_zero[i] = dp_zero[i - 1] + dp_zero[i - 2];
			dp_one[i] = dp_one[i - 1] + dp_one[i - 2];
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());
			sb.append(dp_zero[N] + " " + dp_one[N] + "\n");
		}
		System.out.println(sb);
		in.close();
	}
}