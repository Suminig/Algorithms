import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] count = new int[9];
		String num = in.readLine();
		int max = 0;

		for (int i = 0, size = num.length(); i < size; i++) {
			if (num.charAt(i) - '0' == 9) {
				count[6]++;
			} else {
				count[num.charAt(i) - '0']++;
			}
		}

		count[6] = count[6] % 2 == 0 ? count[6] / 2 : count[6] / 2 + 1;

		for (int x : count) {
			if (x > max)
				max = x;
		}

		sb.append(max);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}