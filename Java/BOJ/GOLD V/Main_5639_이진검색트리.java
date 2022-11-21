import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static int index = 0;
	private static int[] tree = new int[10001];
	private static StringBuilder sb = new StringBuilder();

	public static void postOrder(int n, int end) {
		if (n > end)
			return;

		int mid = n + 1;
		while (mid <= end && tree[mid] < tree[n])
			mid++;

		postOrder(n + 1, mid - 1);
		postOrder(mid, end);
		sb.append(tree[n]).append("\n");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String node = in.readLine();
			if (node == null || node.isEmpty())
				break;

			tree[index++] = Integer.parseInt(node);
		}

		postOrder(0, index - 1);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}