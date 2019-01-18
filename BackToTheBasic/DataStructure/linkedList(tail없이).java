package temp;

public class Main {

	public static void main(String[] args) {
		LinkedList zz = new LinkedList();
		zz.add(5);
		zz.add(10);
		zz.add(500);
		zz.addLast(10000);
		zz.add(-500, zz.size() - 1);
		System.out.println(zz.toString());
		System.out.println(zz.remove(1));
		System.out.println(zz.toString());
	}
}

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	private Node head;
	private int size;

	public LinkedList() {
		this.head = null;
		size = 0;
	}

	public void add(int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
		size++;
	}

	public void addLast(int val) {
		Node lastNode = moveLast();
		Node newNode = new Node(val);
		lastNode.next = newNode;
		size++;
	}

	public void add(int val, int idx) {
		if (idx == 0) {
			add(val);
		} else {
			Node newNode = new Node(val);
			Node cur = head;
			for (int i = 0; i < idx - 1; i++) {
				cur = cur.next;
			}
			newNode.next = cur.next;
			cur.next = newNode;
			size++;
		}
	}

	public int get(int idx) {
		Node cur = head;
		for (int i = 0; i < idx; i++) {
			cur = cur.next;
		}
		return cur.data;
	}

	public int getFirst() {
		return head.data;
	}

	public int getLast() {
		Node lastNode = moveLast();
		return lastNode.data;
	}

	public int size() {
		return this.size;
	}

	public int remove() {
		Node cur = head;
		while (cur.next.next != null) {
			cur = cur.next;
		}
		int removeVal = cur.next.data;
		cur.next = null;
		size--;
		return removeVal;

	}

	public int remove(int x) {
		if (x == 0) {
			return removeFirst();
		} else {
			Node cur = head;
			for (int i = 0; i < x - 1; i++) {
				cur = cur.next;
			}
			Node removeNode = cur.next;
			int removeVal = removeNode.data;
			cur.next = removeNode.next;
			removeNode = null;
			size--;
			return removeVal;
		}
	}

	public int removeFirst() {
		Node remove = head;
		head = head.next;
		size--;
		int removeVal = remove.data;
		remove = null;
		return removeVal;
	}

	public Node moveLast() {
		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		return cur;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		Node cur = head;
		sb.append("[");
		for (int i = 0; i < this.size; i++) {
			sb.append(cur.data + ",");
			cur = cur.next;
		}
		sb.setLength(sb.length() - 1);
		sb.append("]");
		return new String(sb);
	}
}
