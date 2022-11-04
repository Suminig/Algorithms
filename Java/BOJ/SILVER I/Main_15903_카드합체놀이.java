import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Long> pq = new PriorityQueue<>();
		long ans = 0;

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			Long num = Long.parseLong(st.nextToken());
			ans += num;
			pq.offer(num);
		}

		while (M-- > 0) {
			long A = pq.poll();
			long B = pq.poll();
			long sum = A + B;
			ans += 2 * sum - A - B;

			pq.offer(sum);
			pq.offer(sum);
		}

		sb.append(ans);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}