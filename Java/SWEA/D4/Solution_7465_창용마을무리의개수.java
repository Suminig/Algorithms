import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class Solution {
    private static int N, M;
    private static Node[] people;
    private static boolean[] visited;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
 
    private static class Node {
        int num;;
        ArrayList<Integer> list;
 
        public Node(int num, ArrayList<Integer> list) {
            this.num = num;
            this.list = list;
        }
    }
 
    private static void bfs(int num) {
        Deque<Node> q = new ArrayDeque<>();
        q.add(people[num]);
        visited[num] = true;
 
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int idx : cur.list) {
                if (!visited[idx]) {
                    visited[idx] = true;
                    q.add(people[idx]);
                }
            }
        }
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
 
            people = new Node[N + 1];
            for (int i = 1; i <= N; i++)
                people[i] = new Node(i, new ArrayList<>());
            visited = new boolean[N + 1];
 
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                people[A].list.add(B);
                people[B].list.add(A);
            }
 
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    bfs(i);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}