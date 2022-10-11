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
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int size = N + k - 1;
		int[] arr = new int[N + k - 1];
		int[] cnt = new int[d + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		for (int i = N, idx = 0; i < size; i++) {
			arr[i] = arr[idx++];
		}

		int max = 0;
		int temp = 0;

		for (int i = 0; i < k; i++) {
			if (cnt[arr[i]]++ == 0)
				temp++;
		}

		max = cnt[c] == 0 ? Math.max(max, temp + 1) : Math.max(max, temp);
		for (int i = 1; i < size - k; i++) {
			cnt[arr[i - 1]]--;
			if (cnt[arr[i - 1]] == 0)
				temp--;

			if (cnt[arr[i + k - 1]]++ == 0)
				temp++;
			max = cnt[c] == 0 ? Math.max(max, temp + 1) : Math.max(max, temp);
		}

		sb.append(max);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}