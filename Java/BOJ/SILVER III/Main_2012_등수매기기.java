import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		long answer = 0;
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			answer += Math.abs(arr[i] - i - 1);
		}

		sb.append(answer);
		
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}