import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  private static int N;
  private static int[] inorder, postorder, index;
  private static StringTokenizer st;
  private static StringBuilder sb = new StringBuilder();

  public static void preorder(int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd)
      return;

    int root = index[postorder[postEnd]];
    int size = root - inStart;
    sb.append(inorder[root]).append(" ");

    // 왼족
    preorder(inStart, root - 1, postStart, postStart + size - 1);
    // 오른쪽
    preorder(root + 1, inEnd, postStart + size, postEnd - 1);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(in.readLine());
    inorder = new int[N + 1];
    postorder = new int[N + 1];
    index = new int[N + 1];

    st = new StringTokenizer(in.readLine(), " ");
    for (int i = 1; i <= N; i++) {
      inorder[i] = Integer.parseInt(st.nextToken());
      index[inorder[i]] = i;
    }

    st = new StringTokenizer(in.readLine(), " ");
    for (int i = 1; i <= N; i++) {
      postorder[i] = Integer.parseInt(st.nextToken());
    }

    preorder(1, N, 1, N);

    out.write(sb.toString());
    out.flush();
    out.close();
    in.close();
  }
}