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

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] arr = new int[D + 1];
		int[][] shortcuts = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());

			shortcuts[i] = new int[] { start, end, length };
		}

		for (int i = 1; i <= D; i++) {
			arr[i] = arr[i - 1] + 1;
			
			for (int[] shortcut : shortcuts) {
				if(i == shortcut[1])
					arr[i] = Math.min(arr[i], arr[shortcut[0]] + shortcut[2]);
			}
		}
		
		sb.append(arr[D]);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}