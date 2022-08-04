import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int tc = 1; tc <= 10; tc++) {
			Stack<String> stack = new Stack<>();
			int N = Integer.parseInt(in.readLine());
			String line = in.readLine();
			boolean isValid = true;

			for (int i = 0; i < N; i++) {
				char cur = line.charAt(i);
				if (cur == '(' || cur == '[' || cur == '{' || cur == '<') {
					stack.push(cur + "");
				} else if (cur == ')') {
					if (stack.isEmpty() || !stack.peek().equals('(' + "")) {
						isValid = false;
						break;
					}
					stack.pop();
				} else if (cur == ']') {
					if (stack.isEmpty() || !stack.peek().equals('[' + "")) {
						isValid = false;
						break;
					}
					stack.pop();
				} else if (cur == '}') {
					if (stack.isEmpty() || !stack.peek().equals('{' + "")) {
						isValid = false;
						break;
					}
					stack.pop();
				} else if (cur == '>') {
					if (stack.isEmpty() || !stack.peek().equals('<' + "")) {
						isValid = false;
						break;
					}
					stack.pop();
				}
			}
			sb.append("#").append(tc).append(" ");
			if (isValid) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}