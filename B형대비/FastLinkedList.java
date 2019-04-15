class FastLinkedList {
	private final int NODE_SIZE = 100000;
	private int HEAD = NODE_SIZE, TAIL = NODE_SIZE + 1;;
	private int size;
	private Node[] node = new Node[NODE_SIZE + 2];

	public FastLinkedList() {
		size = 0;
		node[HEAD] = new Node();
		node[TAIL] = new Node();
		node[HEAD].next = TAIL;
		node[TAIL].prev = HEAD;
	}

	class Node {
		int val;
		int prev;
		int next;

		public Node() {

		}

		public Node(int value) {
			this.val = value;
		}
	}

	public void addLast(int value) {
		int prev = node[TAIL].prev;
		int next = node[prev].next;

		Node newNode = new Node(value);
		newNode.prev = prev;
		newNode.next = TAIL;

		node[TAIL].prev = size;
		node[prev].next = size;

		node[size] = newNode;
		size += 1;
	}

	public void addFirst(int value) {
		int next = node[HEAD].next;

		Node newNode = new Node(value);
		newNode.next = next;
		newNode.prev = HEAD;

		node[next].prev = size;
		node[HEAD].next = size;

		node[size] = newNode;
		size += 1;
	}

	public void insert(int index, int value) {
		int prev = move(index - 1);
		int next = node[prev].next;

		Node newNode = new Node(value);
		newNode.prev = prev;
		newNode.next = next;

		node[prev].next = size;
		node[next].prev = size;

		node[size] = newNode;
		size += 1;
	}

	public int move(int index) {
		int pos = node[HEAD].next;
		for (int i = 0; i < index; i++) {
			pos = node[pos].next;
		}
		return pos;
	}

	public int removeLast() {
		int target = node[TAIL].prev;

		if (target == HEAD) {
			throw new NullPointerException();
		}

		int prev = node[target].prev;
		node[prev].next = TAIL;
		node[TAIL].prev = prev;

		return node[target].val;
	}

	public int removeFirst() {
		int target = node[HEAD].next;
		if (target == TAIL) {
			throw new NullPointerException();
		}

		int next = node[target].next;
		node[next].prev = HEAD;
		node[HEAD].next = next;

		return node[target].val;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int next = node[HEAD].next;

		if (next == TAIL) {
			return "[]";
		}

		while (next != TAIL) {
			sb.append(node[next].val + ", ");
			next = node[next].next;
		}
		sb.setCharAt(sb.length() - 2, ']');
		return sb.toString();
	}

	public void print() {

		for (int i = 0; i < size; i++) {
			System.out.print(node[i].val + " ");
		}
		System.out.println();
	}

	public void printHead() {
		System.out.println(node[HEAD].next);
		System.out.println(node[HEAD].val);
		System.out.println(node[TAIL].prev);
		System.out.println(node[TAIL].val);
	}

}
