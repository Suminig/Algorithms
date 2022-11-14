import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, R, cnt;
	private static int[] visited;
	private static ArrayList<Integer>[] adjList;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	private static void dfs(int cur) {
		visited[cur] = cnt;
		
		for (int next : adjList[cur]) {
			if(visited[next] == 0) {
				cnt++;
				dfs(next);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjList[u].add(v);
			adjList[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(adjList[i], Collections.reverseOrder());
		}
		
		visited = new int[N+1];
		cnt = 1;
		dfs(R);
		
		for (int i = 1; i <= N; i++) {
			sb.append(visited[i]).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}