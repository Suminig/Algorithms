import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static long sumTrees(long[] trees, long mid) {
		long sum = 0;
		for (long tree : trees) {
			if (tree - mid > 0)
				sum += tree - mid;
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long[] trees = new long[N];

		long left = 0;
		long right = 0;
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			right = Math.max(right, trees[i]);
		}

		while (left < right) {
			long mid = (left + right) / 2;
			long sum = sumTrees(trees, mid);
			if (sum < M)
				right = mid;
			else
				left = mid + 1;
		}

		sb.append(left - 1);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}