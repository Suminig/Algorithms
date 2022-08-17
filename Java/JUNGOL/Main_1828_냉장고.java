import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static class Chemical implements Comparable<Chemical> {
		int low, high;

		public Chemical(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Chemical c) {
			return this.high - c.high != 0 ? this.high - c.high : this.low - c.low;
		}
	}

	private static List<Chemical> getRefrigerator(Chemical[] chemicals) {
		List<Chemical> result = new ArrayList<>();

		Arrays.sort(chemicals);
		result.add(chemicals[0]);

		for (int i = 1, size = chemicals.length; i < size; i++) {
			if (result.get(result.size() - 1).high < chemicals[i].low)
				result.add(chemicals[i]);
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		Chemical[] chemicals = new Chemical[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			chemicals[i] = new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		List<Chemical> list = getRefrigerator(chemicals);

		sb.append(list.size());

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}