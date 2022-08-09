import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] paper = new int[100][100];
		int sum = 0;
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					if (paper[i][j] == 0) {
						paper[i][j] = 1;
						sum += 1;
					}
				}
			}
		}
		sb.append(sum);
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}