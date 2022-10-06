import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			int[] C = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int size = 0;

			for (int i = 0; i < N; i++) {
				int pos = Arrays.binarySearch(C, 0, size, arr[i]);
				if (pos >= 0)
					continue;

				int insertPos = Math.abs(pos) - 1;
				C[insertPos] = arr[i];
				if (insertPos == size)
					size++;
			}
			sb.append(size).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}