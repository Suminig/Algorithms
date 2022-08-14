import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	private static int N, M, R, rotateNum;
	private static int[][] arr;

	private static void rotate(int r) {
		for (int i = 0; i < r; i++) {
			// rotateNum: 돌려야 하는 사각형의 수
			for (int j = 0; j < rotateNum; j++) {
				int temp = arr[j][j];
				// 위 
				for (int k = j+1; k < M-j; k++) {
					arr[j][k-1] = arr[j][k];
				}
				// 오 
				for (int k = j+1; k < N-j; k++) {
					arr[k-1][M-1-j] = arr[k][M-1-j];
				}
				// 하
				for (int k = M-2-j; k >= j; k--) {
					arr[N-1-j][k+1] = arr[N-1-j][k];
				}
				// 왼
				for (int k = N-2-j; k >= j; k--) {
					arr[k+1][j] = arr[k][j];
				}
				arr[j+1][j] = temp;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		rotateNum = Math.min(N, M) / 2;
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		rotate(R);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
        
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}