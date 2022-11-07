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
		
		int T = Integer.parseInt(in.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if (list.get(0) != i) {
					for (int j = list.size() - 1; j >= 0; j--) {
						if (list.get(j) == i) {
							list.remove(j);
							ans += j;
						}
					}
				} else {
					list.remove(0);
				}
			}
			
			sb.append(ans).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}