class HashMap {
	int size, MAX_SIZE;
	final static int HASH_VALUE = 5381;
	LinkedList<Pair>[] hashTable;

	class Pair {
		private int key;
		private String value;

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Pair(int key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
	}

	public HashMap(int MAX_SIZE) {
		super();
		this.MAX_SIZE = MAX_SIZE;
		this.hashTable = new LinkedList[MAX_SIZE];
	}

	public int getHashCode(String str) {
		Long hash = 5381L;
		for (char c : str.toCharArray()) {
			hash = (((hash << 5) + hash) + c) % MAX_SIZE;
		}
		return (int) Math.abs(hash);
	}

	public Pair searchByValue(LinkedList<Pair> list, String value) {
		LinkedList<Pair>.Node cur = list.head;

		while (cur != null) {
			if (cur.data.getValue().equals(value)) {
				return cur.data;
			}
			cur = cur.next;
		}
		return null;
	}

	public void put(String str) {
		int key = getHashCode(str);
		LinkedList<Pair> list = this.hashTable[key];

		if (list == null) {
			list = new LinkedList();
			hashTable[key] = list;
		}

		Pair cur = searchByValue(list, str);
		if (cur == null) {
			Pair newPair = new Pair(key, str);
			list.addLast(newPair);
			this.size += 1;
		} else {
			cur.setValue(str);
		}
	}

	public void remove(String str) {
		int key = getHashCode(str);
		LinkedList<Pair> list = hashTable[key];
		if (list == null) {
			return;
		}

		Pair cur = searchByValue(list, str);
		if (cur != null) {
			list.remove(cur);
			size -= 1;
		}
	}

	public int getSize() {
		return this.size;
	}
}
