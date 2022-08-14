import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				if (Math.abs(i1) == Math.abs(i2)) {
					return i1 - i2;
				}
				return Math.abs(i1) - Math.abs(i2);
			}
		});
        
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(in.readLine());
			if(x == 0) {
				if (heap.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(heap.poll()).append("\n");
				}
			}else {
				heap.offer(x);
			}
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}