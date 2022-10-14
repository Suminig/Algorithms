import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int cnt = N;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] == cnt)
				cnt--;
		}

		sb.append(cnt);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}