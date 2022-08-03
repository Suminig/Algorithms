import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int gcd(int max, int min) {
		int r = max % min;
		
		if(r == 0) {
			return min;
		} else{
			return gcd(min, r);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine(), " ");
		int num_A = Integer.parseInt(st.nextToken());
		int den_A = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine(), " ");
		int num_B = Integer.parseInt(st.nextToken());
		int den_B = Integer.parseInt(st.nextToken());
		
		int num_new = num_A * den_B + den_A * num_B;
		int den_new = den_A * den_B;
		int min = (num_new < den_new) ? num_new : den_new;
		int max = (num_new > den_new) ? num_new : den_new;
		int gcd = gcd(max, min);
		
		sb.append(num_new/gcd).append(" ").append(den_new/gcd);
		System.out.println(sb);
	}
}