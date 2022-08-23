import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    private static int N, M;
    private static int[] parents;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
 
    private static void makeSet() {
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }
 
    private static int find(int x) {
        if (parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }
 
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
 
        if (aRoot != bRoot)
            parents[bRoot] = aRoot;
    }
 
    private static int isSameSet(int a, int b) {
        return find(a) == find(b) ? 1 : 0;
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parents = new int[N+1];
            makeSet();
             
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                int cmd = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                if (cmd == 0)
                    union(A, B);
                else
                    sb.append(isSameSet(A, B));
            }
            sb.append("\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}