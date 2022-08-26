import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static int N, ans;
	private static int[] cols;
	private static StringBuilder sb = new StringBuilder();

	public static boolean isAvailable(int rowNo) {
		for (int i = 1; i < rowNo; i++) {
			if (cols[i] == cols[rowNo] || rowNo - i == Math.abs(cols[rowNo] - cols[i]))
				return false;
		}
		return true;
	}

	public static void setQueen(int rowNo) {
		if (!isAvailable(rowNo - 1))
			return;

		if (rowNo > N) {
			ans++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			cols[rowNo] = i;
			setQueen(rowNo + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());

		cols = new int[N + 1];
		ans = 0;
		
		setQueen(1);
		sb.append(ans);

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}