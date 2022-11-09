import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		List<Integer> ryans = new ArrayList<>();

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (arr[i] == 1)
				ryans.add(i);
		}

		if (ryans.size() < K) {
			sb.append(-1);
		} else {
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < ryans.size(); i++) {
				int right = i;
				int cnt = 0;
				while (right < ryans.size() && cnt < K) {
					cnt++;
					right++;
				}
				
				if(cnt == K) {
					min = Math.min(min, ryans.get(right - 1) - ryans.get(i) + 1);
				}
			}
			
			sb.append(min);
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}