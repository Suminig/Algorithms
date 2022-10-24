import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();

	public static class TrieNode {
		private Map<Character, TrieNode> childNodes = new HashMap<>();
		private boolean isLastChar;

		public Map<Character, TrieNode> getChildNodes() {
			return childNodes;
		}

		public boolean isLastChar() {
			return isLastChar;
		}

		public void setLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}
	}

	public static class Trie {
		private TrieNode rootNode;

		public Trie() {
			this.rootNode = new TrieNode();
		}

		public void insert(String word) {
			TrieNode thisNode = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}

			thisNode.setLastChar(true);
		}

		public boolean contains(String word) {
			TrieNode thisNode = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(c);

				if (node == null)
					return false;

				thisNode = node;
			}

			return true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Trie trie = new Trie();
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			String word = in.readLine();
			trie.insert(word);
		}
		
		for (int i = 0; i < M; i++) {
			String word = in.readLine();
			if(trie.contains(word))
				cnt++;
		}
		
		sb.append(cnt);

		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
}