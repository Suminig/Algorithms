import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(in.readLine());
			LinkedList<String> list = new LinkedList<>();
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			int cmd = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			while (st.hasMoreElements()) {
				if (st.nextToken().equals("I")) {
					int idx = Integer.parseInt(st.nextToken());
					int nums = Integer.parseInt(st.nextToken());
					for (int i = idx; i < idx + nums; i++) {
						list.add(i, st.nextToken());
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}