class Trie {
	Node head;

	class Node {
		boolean isEnd;
		Node[] next;

		public Node() {
			super();
			this.isEnd = false;
			this.next = new Node[10];
		}
	}

	public Trie() {
		super();
		this.head = new Node();
	}

	public void insert(final String str) {
		int len = str.length();

		Node cur = this.head;

		for (int i = 0; i < len; i++) {
			int index = Character.getNumericValue(str.charAt(i));

			if (cur.next[index] == null) {
				cur.next[index] = new Node();
			}
			cur = cur.next[index];
		}
		cur.isEnd = true;
	}

	public boolean find(final String str) {
		int len = str.length();

		Node cur = this.head;
		for (int i = 0; i < len; i++) {
			int index = Character.getNumericValue(str.charAt(i));

			if (cur.next[index] == null) {
				return false;
			}

			cur = cur.next[index];
		}
		return cur.isEnd;
	}
}