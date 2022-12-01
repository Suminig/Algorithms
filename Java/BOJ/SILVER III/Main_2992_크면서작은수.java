import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int N, maxMin, size;
	private static char[] arr, temp;

	public static void dfs(int cnt, int flag) {
		if (cnt == size) {
			int num = Integer.parseInt(new String(temp));
			if (num > N) {
				maxMin = Math.min(maxMin, num);
			}

			return;
		}

		for (int i = 0; i < size; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			temp[cnt] = arr[i];
			dfs(cnt + 1, flag | 1 << i);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		arr = in.readLine().toCharArray();
		N = Integer.parseInt(new String(arr));
		maxMin = Integer.MAX_VALUE;
		size = arr.length;
		temp = new char[size];

		dfs(0, 0);
		sb.append(maxMin == Integer.MAX_VALUE ? 0 : maxMin);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}