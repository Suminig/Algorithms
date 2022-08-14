import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int min = Integer.MAX_VALUE;
	private static int[] sour, bit;
	private static boolean[] visited;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static void subset(int index) {
		if (index == N) {
			int sourNum = 1;
			int bitNum = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i])
					continue;
				sourNum *= sour[i];
				bitNum += bit[i];
			}
			if (sourNum == 1 && bitNum == 0)
				return;
			min = Math.min(min, Math.abs(sourNum - bitNum));
			return;
		}
		visited[index] = true;
		subset(index + 1);
		visited[index] = false;
		subset(index + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(in.readLine());
		sour = new int[N];
		bit = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bit[i] = Integer.parseInt(st.nextToken());
		}

		subset(0);
		sb.append(min);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}