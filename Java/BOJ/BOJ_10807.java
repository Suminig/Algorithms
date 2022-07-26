import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int cnt = 0;
		
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		String v = in.readLine();
		for (int i = 0; i < N; i++) {
			if (st.nextToken().equals(v))
				cnt++;
		}
		
		System.out.println(cnt);
		in.close();
	}
}
