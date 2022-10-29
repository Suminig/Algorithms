import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		String[] nums = new String[N];
		for (int i = 0; i < N; i++) {
			nums[i] = in.readLine();
		}

		int K = 0;
		int len = nums[0].length();
		while (true) {
			K++;
			Map<String, Integer> cnt = new HashMap<>();
			boolean next = false;

			for (String num : nums) {
				String last = num.substring(len - K);
				if (cnt.containsKey(last)) {
					next = true;
					break;
				} else {
					cnt.put(last, 1);
				}
			}

			if (next)
				continue;

			sb.append(K);
			break;
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}