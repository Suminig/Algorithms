import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	private static int N, ans;
	private static int[] arr, numbers;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static void perm(int cnt, int flag) {
		if (cnt == N) {
			weight(numbers, 0, 0, 0);
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			numbers[cnt] = arr[i];
			perm(cnt + 1, flag | 1 << i);
		}
	}

	private static void weight(int[] nums, int left, int right, int cnt) {
		if (cnt == N) {
			ans++;
			return;
		}

		weight(nums, left + nums[cnt], right, cnt + 1);
		if (left >= right + nums[cnt])
			weight(nums, left, right + nums[cnt], cnt + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			ans = 0;
			numbers = new int[N];
			perm(0, 0);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}