import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    private static int V, E;
    private static int[] parents;
    private static Edge[] edgeList;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
 
    private static class Edge implements Comparable<Edge> {
        int from, to, weight;
 
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
 
    private static void makeSet() {
        parents = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }
 
    private static int find(int a) {
        if (parents[a] == a)
            return a;
 
        return parents[a] = find(parents[a]);
    }
 
    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
 
        if (aRoot == bRoot)
            return false;
 
        parents[bRoot] = aRoot;
        return true;
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(in.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
 
            edgeList = new Edge[E];
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(A, B, C);
            }
 
            makeSet();
            Arrays.sort(edgeList);
             
            long result = 0;
            int cnt = 0;
            for (Edge edge : edgeList) {
                if (union(edge.from, edge.to)) {
                    result += edge.weight;
                    if (++cnt == V - 1)
                        break;
                }
            }
            sb.append(result).append("\n");
        }
 
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}