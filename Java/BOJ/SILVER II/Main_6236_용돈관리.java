import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, sum;
	private static int[] arr;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static boolean check(int money) {
		int cnt = 1;
		int temp = money;

		for (int x : arr) {
			if (money < x)
				return false;

			if (temp < x) {
				cnt++;
				temp = money;
			}

			temp -= x;
		}

		return M >= cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			sum += arr[i];
		}

		int left = 1, right = sum;
		int res = 0;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (check(mid)) {
				res = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		sb.append(res);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}