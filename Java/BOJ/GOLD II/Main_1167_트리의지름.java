import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  private static int V, max, end;
  private static boolean[] visited;
  private static List<Node>[] nodes;
  private static StringTokenizer st;
  private static StringBuilder sb = new StringBuilder();

  public static class Node {
    int num, weight;

    public Node(int num, int weight) {
      this.num = num;
      this.weight = weight;
    }
  }

  public static void dfs(int cur, int sum) {
    if (max < sum) {
      max = sum;
      end = cur;
    }

    visited[cur] = true;

    for (Node next : nodes[cur]) {
      if (visited[next.num])
        continue;
      dfs(next.num, sum + next.weight);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    V = Integer.parseInt(in.readLine());
    nodes = new ArrayList[V + 1];
    for (int i = 0; i <= V; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 1; i <= V; i++) {
      st = new StringTokenizer(in.readLine(), " ");
      int from = Integer.parseInt(st.nextToken());
      while (true) {
        int to = Integer.parseInt(st.nextToken());
        if (to == -1)
          break;

        int dist = Integer.parseInt(st.nextToken());
        nodes[from].add(new Node(to, dist));
        nodes[to].add(new Node(from, dist));
      }
    }

    visited = new boolean[V + 1];
    dfs(1, 0);

    visited = new boolean[V + 1];
    dfs(end, 0);

    sb.append(max);

    out.write(sb.toString());
    out.flush();
    out.close();
    in.close();
  }
}