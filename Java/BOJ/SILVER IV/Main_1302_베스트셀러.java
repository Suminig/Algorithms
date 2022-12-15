import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<String, Integer> books = new HashMap<>();

		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			String book = in.readLine();

			if (books.containsKey(book))
				books.put(book, books.get(book) + 1);
			else
				books.put(book, 1);
		}

		String[] titles = new String[books.keySet().size()];
		books.keySet().toArray(titles);
		Arrays.sort(titles);

		int max = 0;
		String res = "";
		for (String title : titles) {
			if (books.get(title) > max) {
				max = books.get(title);
				res = title;
			}
		}

		sb.append(res);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}