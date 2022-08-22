import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class Solution {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
 
    private static class Node {
        int num;
        ArrayList<Integer> list;
 
        public Node(int num, ArrayList<Integer> list) {
            this.num = num;
            this.list = list;
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
 
        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            Node[] contacts = new Node[101];
            for (int i = 1; i < 101; i++) {
                contacts[i] = new Node(i, new ArrayList<>());
            }
 
            st = new StringTokenizer(in.readLine(), " ");
            while (st.hasMoreElements()) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                contacts[from].list.add(to);
            }
 
            Deque<Node> q = new ArrayDeque<>();
            int[] visited = new int[101];
            q.add(contacts[V]);
            visited[V] = 1;
            int maxConnect = visited[V];
 
            while (!q.isEmpty()) {
                Node cur = q.poll();
                int num = cur.num;
 
                for (int b : cur.list) {
                    if (visited[b] > 0)
                        continue;
 
                    visited[b] = visited[num] + 1;
                    maxConnect = Math.max(maxConnect, visited[b]);
                    q.add(contacts[b]);
                }
            }
 
            int maxNum = 0;
            for (int i = 100; i >= 0; i--) {
                if (visited[i] == maxConnect) {
                    maxNum = i;
                    break;
                }
            }
            sb.append("#").append(tc).append(" ").append(maxNum).append("\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}