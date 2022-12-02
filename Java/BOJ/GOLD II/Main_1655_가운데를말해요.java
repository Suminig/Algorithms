import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());

		PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());

			if (min.size() == max.size())
				max.offer(num);
			else
				min.offer(num);

			if ((!min.isEmpty() && !max.isEmpty()) && min.peek() < max.peek()) {
				int temp = min.poll();
				min.offer(max.poll());
				max.offer(temp);
			}

			sb.append(max.peek()).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}