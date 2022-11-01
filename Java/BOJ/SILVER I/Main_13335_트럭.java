import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, W, L, sum, time;
	private static Queue<Integer> trucks, bridge;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine(), " ");
		trucks = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			trucks.offer(Integer.parseInt(st.nextToken()));
		}

		time = sum = 0;
		bridge = new ArrayDeque<>();
		for (int i = 0; i < W; i++) {
			bridge.offer(0);
		}

		while (!bridge.isEmpty()) {
			time++;
			sum -= bridge.poll();

			if (!trucks.isEmpty()) {
				if (sum + trucks.peek() <= L) {
					sum += trucks.peek();
					bridge.offer(trucks.poll());
				} else {
					bridge.offer(0);
				}
			}
		}

		sb.append(time);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}