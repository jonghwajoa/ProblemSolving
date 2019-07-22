
class LinkedList<T> {
	Node head;
	Node tail;
	int size;

	class Node {
		T data;
		Node next, prev;

		public Node() {
			super();
		}
	}

	public LinkedList() {
		super();
		size = 0;
		head = null;
		tail = null;
	}

	public void addFirst(T data) {
		Node newNode = new Node();
		newNode.data = data;

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		size += 1;
	}

	public void add(T data, int idx) {
		if (idx == 0) {
			addFirst(data);
			return;
		} else if (size <= idx) {
			// TODO : addLast
		} else {
			Node newNode = new Node();
			newNode.data = data;
			Node nextNode = move(idx);
			newNode.prev = nextNode.prev;
			nextNode.prev.next = newNode;
			newNode.next = nextNode;
			nextNode.prev = newNode;
		}

		size += 1;
	}

	public void addLast(T data) {
		if (size == 0) {
			addFirst(data);
			return;
		}

		Node newNode = new Node();
		newNode.data = data;

		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		size += 1;
	}

	public Node move(int idx) {
		if (size <= idx) {
			return tail;
		}

		Node cur = null;
		if (idx < size / 2) {
			cur = head;
			for (int i = 0; i < idx; i++) {
				cur = cur.next;
			}
		} else {
			cur = tail;
			for (int i = size - 1; idx < i; i--) {
				cur = cur.prev;
			}
		}
		return cur;
	}

	public void print() {
		Node cur = head;
		StringBuilder sb = new StringBuilder();
		while (cur != null) {
			sb.append(cur.data + "\n");
			cur = cur.next;
		}
		System.out.println(sb.toString());
	}

	public void removeFirst() {
		Node remove = head;
		head = remove.next;
		remove.prev = null;
		remove.next = null;
		size -= 1;
	}

	public void removeLast() {
		Node remove = tail;
		tail = remove.prev;
		remove.prev.next = null;
		remove.prev = null;
		size -= 1;
	}

	public void remove(T data) {
		Node cur = head;

		for (int i = 0; i < size; i++) {
			if (cur.data == data) {
				if (i == 0) {
					removeFirst();
				} else if (i == size - 1) {
					removeLast();
				} else {
					Node prev = cur.prev;
					Node next = cur.next;
					prev.next = next;
					next.prev = prev;
				}
				break;
			}
			cur = cur.next;
		}

		while (cur != null) {
			if (cur.data == data) {

				break;
			}
			cur = cur.next;
		}
	}
}
