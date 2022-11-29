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

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dpUp = new int[N];
		int[] dpDown = new int[N];

		for (int i = 0; i < N; i++) {
			dpUp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dpUp[i] < dpUp[j] + 1)
					dpUp[i] = dpUp[j] + 1;
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			dpDown[i] = 1;

			for (int j = N - 1; j > i; j--) {
				if (arr[j] < arr[i] && dpDown[i] < dpDown[j] + 1)
					dpDown[i] = dpDown[j] + 1;
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dpUp[i] + dpDown[i] - 1);
		}

		sb.append(max);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}