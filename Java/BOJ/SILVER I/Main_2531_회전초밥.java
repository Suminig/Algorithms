import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, d, k, c, cnt, max;
	private static int[] arr, cntNum;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[N + k - 1];
		cntNum = new int[d + 1];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		for (int i = N, idx = 0; i < N + k - 1; i++) {
			arr[i] = arr[idx++];
		}

		cnt = 0;
		for (int i = 0; i < k; i++) {
			if (cntNum[arr[i]]++ == 0)
				cnt++;
		}
		max = cntNum[c] == 0 ? cnt + 1 : cnt;

		for (int i = 1; i < N - 1; i++) {
			if (--cntNum[arr[i - 1]] == 0)
				cnt--;

			if (cntNum[arr[i + k - 1]]++ == 0)
				cnt++;

			max = Math.max(max, cntNum[c] == 0 ? cnt + 1 : cnt);
		}

		sb.append(max);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}