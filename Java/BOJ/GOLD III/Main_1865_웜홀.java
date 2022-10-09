import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  private static StringTokenizer st;
  private static StringBuilder sb = new StringBuilder();

  public static class Edge {
    int num, time;

    public Edge(int num, int time) {
      this.num = num;
      this.time = time;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int TC = Integer.parseInt(in.readLine());
    for (int tc = 0; tc < TC; tc++) {
      boolean isCycle = false;

      st = new StringTokenizer(in.readLine(), " ");
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int W = Integer.parseInt(st.nextToken());

      List<Edge>[] edgeList = new ArrayList[N + 1];
      for (int i = 1; i <= N; i++) {
        edgeList[i] = new ArrayList<>();
      }

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(in.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        edgeList[S].add(new Edge(E, T));
        edgeList[E].add(new Edge(S, T));
      }

      for (int i = 0; i < W; i++) {
        st = new StringTokenizer(in.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        edgeList[S].add(new Edge(E, -T));
      }

      int[] dists = new int[N + 1];
      Arrays.fill(dists, 123456789);
      dists[1] = 0;
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          for (Edge edge : edgeList[j]) {
            if (dists[edge.num] > dists[j] + edge.time) {
              dists[edge.num] = dists[j] + edge.time;

              if (i == N)
                isCycle = true;
            }
          }
        }
      }
      sb.append(isCycle ? "YES" : "NO").append("\n");
    }
    out.write(sb.toString());
    out.flush();
    out.close();
    in.close();
  }
}