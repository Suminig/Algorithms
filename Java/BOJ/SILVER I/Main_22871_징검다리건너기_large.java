import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		long[] arr = new long[N + 1];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		long left = 1;
		long right = (N - 1) * (1 + Math.abs(arr[N] - arr[1]));
		long ans = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			boolean flag = false;
			Stack<Integer> stack = new Stack<>();
			boolean[] visited = new boolean[N + 1];

			stack.push(1);
			visited[1] = true;

			while (!stack.isEmpty()) {
				int cur = stack.pop();

				if (cur == N) {
					flag = true;
					break;
				}

				for (int i = cur + 1; i <= N; i++) {
					long temp = (i - cur) * (1 + Math.abs(arr[i] - arr[cur]));
					if (temp <= mid && !visited[i]) {
						stack.push(i);
						visited[i] = true;
					}
				}
			}

			if (flag) {
				right = mid - 1;
				ans = mid;
			} else {
				left = mid + 1;
			}
		}

		sb.append(ans);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}