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

		int N = Integer.parseInt(in.readLine());
		long[] arr = new long[N];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		int left = 0;
		int right = N - 1;
		int l = 0, r = 0;
		long min = Long.MAX_VALUE;
		while (left < right) {
			long sum = arr[left] + arr[right];
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				l = left;
				r = right;
			}

			if (sum >= 0) {
				right--;
			} else {
				left++;
			}
		}

		sb.append(arr[l]).append(" ").append(arr[r]);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}