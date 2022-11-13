import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(arr);

		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int left = i, right = N;

			while (left < right) {
				int mid = (left + right) / 2;
				if (arr[mid] - arr[i] < M) {
					left = mid + 1;
				} else {
					right = mid;
				}

				if (right == N)
					continue;

				answer = Math.min(answer, arr[right] - arr[i]);

				if (answer == M)
					break;
			}
		}

		sb.append(answer);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}