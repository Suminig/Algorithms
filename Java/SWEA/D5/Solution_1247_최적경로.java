import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    private static int minDistance;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
 
    private static class Pair {
        int x, y;
 
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
 
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(this.x).append(" ").append(this.y).append(")");
            return sb.toString();
        }
    }
 
    private static int dist(Pair[] path, Pair start, Pair end) {
        int distance = 0;
        distance += (Math.abs(start.x - path[0].x) + Math.abs(start.y - path[0].y));
        for (int i = 0, size = path.length; i < size - 1; i++) {
            distance += (Math.abs(path[i].x - path[i + 1].x) + Math.abs(path[i].y - path[i + 1].y));
        }
        distance += (Math.abs(path[path.length - 1].x - end.x) + Math.abs(path[path.length - 1].y - end.y));
        return distance;
    }
 
    private static void perm(int left, Pair[] src, Pair[] p, int flag, Pair start, Pair end) {
        if (left == 0) {
            minDistance = Math.min(minDistance, dist(p, start, end));
            return;
        }
 
        for (int i = 0; i < src.length; i++) {
            if ((flag & 1 << i) != 0) {
                continue;
            }
            p[p.length - left] = src[i];
            perm(left - 1, src, p, flag | 1 << i, start, end);
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine(), " ");
            Pair company = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Pair home = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Pair[] clients = new Pair[N];
            for (int i = 0; i < N; i++) {
                clients[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
 
            minDistance = Integer.MAX_VALUE;
            perm(N, clients, new Pair[N], 0, company, home);
            sb.append("#").append(tc).append(" ").append(minDistance).append("\n");
        }
 
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}