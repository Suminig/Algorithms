import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < N; i++) {
			String book = in.readLine();
			if (map.containsKey(book))
				map.put(book, map.get(book) + 1);
			else
				map.put(book, 1);
		}

		String[] books = new String[map.keySet().size()];
		map.keySet().toArray(books);
		Arrays.sort(books);

		int max = 0;
		String maxBook = "";
		for (String b : books) {
			if (map.get(b) > max) {
				max = map.get(b);
				maxBook = b;
			}
		}
		System.out.println(maxBook);
	}
}
