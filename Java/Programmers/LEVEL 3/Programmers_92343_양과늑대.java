import java.util.ArrayList;

class Solution {
	private int max;
	private int[] info;
	private Node[] nodes;

	public class Node {
		int left, right;

		public Node() {
			left = -1;
			right = -1;
		}
	}

	public void dfs(int cur, int sheep, int wolf, ArrayList<Integer> list) {
		if (info[cur] == 0)
			sheep++;
		else
			wolf++;

		if (wolf >= sheep)
			return;

		max = Math.max(max, sheep);
		ArrayList<Integer> newList = new ArrayList<>();
		newList.addAll(list);
		newList.remove(Integer.valueOf(cur));

		int left = nodes[cur].left, right = nodes[cur].right;
		if (left > 0 && !newList.contains(left))
			newList.add(left);
		if (right > 0 && !newList.contains(right))
			newList.add(right);

		for (Integer node : newList)
			dfs(node, sheep, wolf, newList);
	}

	public int solution(int[] info, int[][] edges) {
		int N = info.length;
		nodes = new Node[N];
		this.info = info;

		for (int i = 0; i < N; i++) {
			nodes[i] = new Node();
		}

		for (int[] edge : edges) {
			int parent = edge[0], child = edge[1];
			if (nodes[parent].left == -1) {
				nodes[parent].left = child;
			} else {
				nodes[parent].right = child;
			}
		}

		max = 0;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		dfs(0, 0, 0, list);

		return max;
	}
}