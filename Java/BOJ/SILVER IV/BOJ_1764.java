import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> dict = new HashMap<>();
		List<String> deutbo = new ArrayList<>();

		for (int i = 0; i < N + M; i++) {
			String name = in.readLine();
			if (dict.containsKey(name)) {
				deutbo.add(name);
			} else {
				dict.put(name, 1);
			}
		}

		Collections.sort(deutbo);
		sb.append(deutbo.size()).append("\n");
		for (int i = 0; i < deutbo.size(); i++) {
			if (i == deutbo.size() - 1)
				sb.append(deutbo.get(i));
			else
				sb.append(deutbo.get(i)).append("\n");
		}

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}