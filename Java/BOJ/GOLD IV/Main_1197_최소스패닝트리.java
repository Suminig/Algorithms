import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int V, E;
	private static int[] parents;
	private static Node[] adjList;
	private static Edge[] edgeList;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class Edge implements Comparable<Edge> {
		int from, to;
		long weight;

		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) (this.weight - o.weight);
		}
	}

	public static class Node {
		int vertex;
		long weight;
		Node next;

		public Node(int vertex, long weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}

	public static class Vertex {
		int no;
		long weight;

		public Vertex(int no, long weight) {
			this.no = no;
			this.weight = weight;
		}

	}

	public static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static long kruskal() {
		parents = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			parents[i] = i;
		}

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
		return result;
	}

	public static long prim() {
		long[] minEdge = new long[V + 1];
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);

		minEdge[1] = 0;
		long result = 0;

		for (int i = 0; i < V; i++) {
			long min = Long.MAX_VALUE;
			int minVertex = -1;
			for (int j = 1; j < V + 1; j++) {
				if (!visited[j] && minEdge[j] < min) {
					min = minEdge[j];
					minVertex = j;
				}
			}

			visited[minVertex] = true;
			result += min;

			for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
				}
			}
		}
		return result;
	}

	public static long primPQ() {
		long[] minEdge = new long[V + 1];
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);

		minEdge[1] = 0;
		long result = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> (int) (v1.weight - v2.weight));
		pq.offer(new Vertex(1, minEdge[1]));

		int cnt = 0;
		while (true) {
			Vertex minVertex = pq.poll();

			if (visited[minVertex.no])
				continue;

			visited[minVertex.no] = true;
			result += minVertex.weight;
			if (++cnt == V)
				break;

			for (Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
					pq.offer(new Vertex(temp.vertex, minEdge[temp.vertex]));
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adjList = new Node[V + 1];
		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Integer.parseInt(st.nextToken());

			edgeList[i] = new Edge(from, to, weight);
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}

//		sb.append(kruskal());	// 두 번째로 빠름
//		sb.append(prim());		// 제일 느림
		sb.append(primPQ()); // 제일 빠름

		out.write(sb.toString());
		out.flush();
		out.close();
	}
}