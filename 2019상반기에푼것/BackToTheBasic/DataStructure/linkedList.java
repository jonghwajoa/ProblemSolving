package temp;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.addFirst(500);
		list.addLast(50000);
		System.out.println(list.indexOf(300));
		System.out.println(list.indexOf(500));
		System.out.println(list.indexOf(50000));
		System.out.println(list.toString());
	}
}

class LinkedList {
	private int size = 0;
	private Node head, tail;

	private class Node {
		private Object data;
		private Node next;

		public Node(Object data) {
			this.data = data;
			this.next = null;
		}

		public String toString() {
			return String.valueOf(this.data);
		}
	}

	public void addFirst(Object data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		size++;
		if (head.next == null) {
			tail = newNode;
		}
	}

	public void addLast(Object data) {
		if (size == 0) {
			addFirst(data);
		} else {
			Node newNode = new Node(data);
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}

	public void add(int index, Object data) {
		if (index == 0) {
			addFirst(data);
		} else {
			Node cur = node(index - 1);
			Node newNode = new Node(data);
			newNode.next = cur.next;
			cur.next = newNode;
			size++;
			if (newNode.next == null) {
				tail = newNode;
			}
		}
	}

	private Node node(int index) {
		Node cur = head;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur;
	}

	public String toString() {
		if (head == null) {
			return new String("[]");
		}

		StringBuilder sb = new StringBuilder();
		Node cur = head;
		sb.append("[");
		while (cur.next != null) {
			sb.append(cur.data + ",");
			cur = cur.next;
		}
		sb.append(cur.data + "]");
		return new String(sb);
	}

	public Object removeFirst() {
		Object removeVal = head.data;
		head = head.next;
		size--;
		return removeVal;
	}

	public Object remove(int index) {
		if (index == 0) {
			return removeFirst();
		}

		Node cur = node(index - 1);
		Node remove = cur.next;
		cur.next = remove.next;
		Object removeVal = remove.data;
		if (tail == remove) {
			tail = cur;
		}

		remove = null;
		size--;
		return removeVal;
	}

	public int size() {
		return size;
	}

	public Object get(int index) {
		return node(index).data;
	}

	public int indexOf(Object data) {
		Node cur = head;

		int i = 0;
		while (!cur.data.equals(data)) {
			i++;
			cur = cur.next;
			if (cur == null) {
				return -1;
			}
		}
		return i;
	}

}