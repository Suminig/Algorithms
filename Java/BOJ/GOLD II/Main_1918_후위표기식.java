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

		String str = in.readLine();
		Stack<Character> s = new Stack<>();

		for (int i = 0, size = str.length(); i < size; i++) {
			char cur = str.charAt(i);
			if (cur >= 'A' && cur <= 'Z') {
				sb.append(cur);
			} else {
				if (cur == '(') {
					s.push(cur);
				} else if (cur == ')') {
					while (!s.isEmpty() && s.peek() != '(') {
						sb.append(s.pop());
					}
					s.pop();
				} else if (cur == '*' || cur == '/') {
					while (!s.isEmpty() && (s.peek() == '*' || s.peek() == '/')) {
						sb.append(s.pop());
					}
					s.push(cur);
				} else {
					while (!s.isEmpty() && (s.peek() != '(')) {
						sb.append(s.pop());
					}
					s.push(cur);
				}
			}
		}

		while (!s.isEmpty()) {
			sb.append(s.pop());
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}