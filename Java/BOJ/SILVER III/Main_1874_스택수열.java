import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(in.readLine());
		int num = 1;

		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(in.readLine());

			while (num <= cur) {
				stack.push(num++);
				sb.append("+\n");
			}

			if(num == cur) {
				stack.pop();
				sb.append("-\n");
			}else if(num > cur){
				if (stack.peek() == cur) {
					stack.pop();
					sb.append("-\n");
				}else {
					break;
				}
			}
		}
		
		if (!stack.isEmpty()) {
			sb = new StringBuilder();
			sb.append("NO");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}