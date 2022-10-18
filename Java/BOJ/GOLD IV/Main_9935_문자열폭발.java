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
		String bomb = in.readLine();

		int length = bomb.length();
		char head = bomb.charAt(0);
		Stack<Character> stack = new Stack<>();

		for (int i = str.length() - 1; i >= 0; i--) {
			stack.push(str.charAt(i));

			if (stack.peek() == head && stack.size() >= length) {
				StringBuilder word = new StringBuilder();
				for (int j = 0; j < length; j++) {
					word.append(stack.pop());
				}

				if (word.toString().equals(bomb)) {
					continue;
				} else {
					for (int j = length - 1; j >= 0; j--) {
						stack.push(word.charAt(j));
					}
				}
			}

		}

		if (stack.isEmpty())
			sb.append("FRULA");
		else {
			while (!stack.isEmpty())
				sb.append(stack.pop());
		}

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}