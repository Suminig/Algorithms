import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static String prefix = "--";
	private static StringBuilder sb = new StringBuilder();

	public static class TrieNode {
		private Map<String, TrieNode> childNodes = new HashMap<>();

		public Map<String, TrieNode> getChildNodes() {
			return childNodes;
		}
	}

	public static class Trie {
		private TrieNode rootNode;

		public Trie() {
			this.rootNode = new TrieNode();
		}

		public void insert(String[] words) {
			TrieNode thisNode = this.rootNode;

			for (int i = 1; i <= Integer.parseInt(words[0]); i++) {
				thisNode = thisNode.getChildNodes().computeIfAbsent(words[i], w -> new TrieNode());
			}
		}
	}

	public static void dfs(TrieNode node, int cnt) {
		Object[] keys = node.childNodes.keySet().toArray();
		Arrays.sort(keys);
		
		for (Object key : keys) {
			key = (String) key;
			
			for (int i = 0; i < cnt; i++) {
				sb.append(prefix);
			}
			sb.append(key).append("\n");

			if (node.childNodes.get(key) != null) {
				dfs(node.childNodes.get(key), cnt + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		Trie trie = new Trie();

		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			String[] words = in.readLine().split(" ");
			trie.insert(words);
		}

		dfs(trie.rootNode, 0);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}