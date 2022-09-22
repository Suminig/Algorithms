import java.util.*;

class Solution {
	public class Node {
		int max;
		boolean visited, isSummit;
		ArrayList<Integer> adjList;
		HashMap<Integer, Integer> map;

		public Node() {
			max = Integer.MAX_VALUE;
			adjList = new ArrayList<>();
			map = new HashMap<>();
		}
	}

	private int n, min, bestSummit;
	private int[] summits;
	private HashMap<Integer, Node> nodes;

	public void dfs(int cur, int intensity) {
		Node node = nodes.get(cur);
		node.max = Math.min(node.max, intensity);

		if (intensity > min)
			return;

		if (node.isSummit) {
			if (node.max < min) {
				bestSummit = cur;
				min = intensity;
			} else if (node.max == min) {
				bestSummit = Math.min(bestSummit, cur);
			}
			return;
		}

		for (int idx : node.adjList) {
			Node next = nodes.get(idx);
			if (next.visited || next.max <= intensity)
				continue;

			next.visited = true;
			dfs(idx, Math.max(intensity, node.map.get(idx)));
			next.visited = false;
		}
	}

	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		this.n = n;
		this.summits = summits;
		nodes = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			nodes.put(i, new Node());
		}

		for (int summit : summits) {
			nodes.get(summit).isSummit = true;
		}

		for (int[] path : paths) {
			int a = path[0], b = path[1], weight = path[2];
			nodes.get(a).adjList.add(b);
			nodes.get(a).map.put(b, weight);
			nodes.get(b).adjList.add(a);
			nodes.get(b).map.put(a, weight);
		}

		min = Integer.MAX_VALUE;
		bestSummit = n + 1;

		for (int gate : gates) {
			dfs(gate, 0);
		}

		return new int[] { bestSummit, min };
	}
}