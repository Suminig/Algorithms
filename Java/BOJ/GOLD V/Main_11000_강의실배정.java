import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Room implements Comparable<Room> {
		int start, end;

		public Room(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Room r) {
			return this.start == r.start ? this.end - r.end : this.start - r.start;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		Room[] arr = new Room[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[i] = new Room(start, end);
		}

		Arrays.sort(arr);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(arr[0].end);

		for (int i = 1; i < N; i++) {
			if (arr[i].start >= pq.peek())
				pq.poll();

			pq.offer(arr[i].end);
		}

		sb.append(pq.size());

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}