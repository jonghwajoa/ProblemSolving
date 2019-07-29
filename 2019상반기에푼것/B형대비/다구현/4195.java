import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	static int[] p, d;
	static StringBuilder sb;

	public static void main(String[] argv) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		while (N-- > 0) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap(200001);

			final int SIZE = n * 2;
			p = new int[SIZE];
			d = new int[SIZE];
			for (int i = 0; i < SIZE; i++) {
				p[i] = i;
				d[i] = 1;
			}

			int index = 0;
			for (int i = 0; i < n; i++) {
				String[] line = br.readLine().split(" ");
				if (!map.containsKey(line[0])) {
					map.put(line[0], index++);
				}

				if (!map.containsKey(line[1])) {
					map.put(line[1], index++);
				}

				int key1 = map.get(line[0]);
				int key2 = map.get(line[1]);
				union(key1, key2);
			}
		}
		System.out.println(sb.toString());

	}

	public static int find(int x) {
		if (p[x] == x) {
			return x;
		}

		return p[x] = find(p[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x > y) {
			int tmp = x;
			x = y;
			y = tmp;
		}

		if (x != y) {
			p[y] = x;
			d[x] += d[y];
		}
		sb.append(d[x] + "\n");
	}
}

class HashMap<T, V> {
	LinkedList<Pair>[] hashTable;
	final int PRIME = 5381;
	int size;
	int MAX_SIZE;

	class Pair {
		T key;
		V value;

		public Pair(T key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		public T getKey() {
			return key;
		}

		public void setKey(T key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}

	public HashMap(int MAX_SIZE) {
		super();
		this.hashTable = new LinkedList[MAX_SIZE];
		this.size = 0;
		this.MAX_SIZE = MAX_SIZE;
	}

	private int getHashCode(T key) {
		Long hash = 1L;
		String strKey = key.toString();
		for (char c : strKey.toCharArray()) {
			hash = (((hash << 5) + hash) + c) % this.MAX_SIZE;
		}
		return (int) Math.abs(hash);
	}

	private Pair searchByKey(LinkedList<Pair> list, T key) {
		LinkedList<HashMap<T, V>.Pair>.Node cur = list.head;

		while (cur != null) {
			if (cur.data.getKey().equals(key)) {
				return cur.data;
			}
			cur = cur.next;
		}

		return null;
	}

	public void put(T key, V value) {
		int index = getHashCode(key);
		LinkedList<Pair> list = hashTable[index];
		if (list == null) {
			list = new LinkedList<>();
			hashTable[index] = list;
		}

		Pair search = searchByKey(list, key);
		if (search == null) {
			Pair newNode = new Pair(key, value);
			list.addLast(newNode);
		} else {
			search.setValue(value);
		}
	}

	public boolean containsKey(T key) {
		int index = getHashCode(key);
		LinkedList<Pair> list = hashTable[index];
		if (list != null) {
			Pair node = searchByKey(list, key);
			if (node != null) {
				return true;
			}

		}
		return false;
	}

	public V get(T key) {
		int index = getHashCode(key);
		LinkedList<Pair> list = hashTable[index];
		if (list != null) {
			Pair node = searchByKey(list, key);
			if (node != null) {
				return node.value;
			}
		}
		return null;
	}

}

class LinkedList<T> {
	Node head, tail;
	int size;

	class Node {
		T data;
		Node next, prev;

		public Node(T data) {
			super();
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void addFist(T data) {
		Node newNode = new Node(data);
		if (head == null) {
			tail = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
		}
		head = newNode;
		size += 1;
	}

	public void addLast(T data) {
		Node newNode = new Node(data);
		if (tail == null) {
			head = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
		}
		tail = newNode;
		size += 1;
	}

	public void add(T data, int idx) {
		if (idx == 0) {
			addFist(data);
		} else if (size - 1 <= idx) {
			addLast(data);
		} else {
			Node nextNode = move(idx);
			Node newNode = new Node(data);
			Node prevNode = nextNode.prev;

			newNode.next = nextNode;
			newNode.prev = prevNode;
			nextNode.prev = newNode;
			prevNode.next = newNode;
			size += 1;
		}
	}

	public Node move(int idx) {
		Node cur;
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

}
