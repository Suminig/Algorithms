import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 987654321;
    private static int N, M;
    private static ArrayList<Edge> edges;
    private static long[] dist;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static boolean bellman() {
        for (int i = 1; i <= N; i++) {
            for (Edge edge : edges) {
                if (dist[edge.from] == INF)
                    continue;

                if (dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;

                    if (i == N) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, cost));
        }

        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        if (bellman()) {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
        } else {
            sb.append(-1).append("\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
        in.close();
    }
}