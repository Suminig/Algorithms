import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		int move = 0;
		st = new StringTokenizer(in.readLine(), " ");
		while (st.hasMoreElements()) {
			int num = Integer.parseInt(st.nextToken());
			if (num == q.peek()) {
				q.poll();
			} else {
				Deque<Integer> q_left = new ArrayDeque<>(q);
				Deque<Integer> q_right = new ArrayDeque<>(q);
				int temp_left = 0, temp_right = 0;
				while (num != q_left.peek()) {
					q_left.offerFirst(q_left.pollLast());
					temp_left++;
				}
				while (num != q_right.peek()) {
					q_right.offer(q_right.poll());
					temp_right++;
				}
				if (temp_left < temp_right) {
					q = q_left;
					q.poll();
					move += temp_left;
				} else {
					q = q_right;
					q.poll();
					move += temp_right;
				}
			}
		}
        
		sb.append(move);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}