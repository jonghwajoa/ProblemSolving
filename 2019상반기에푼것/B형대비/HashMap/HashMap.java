public class HashMap {
    private BasicLinkedList<Pair>[] hashTable;
    private final int PN;
    private final int SIZE;
    private int keyCount;

    class Pair {
        private String key;
        private String value;

        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public HashMap(int size) {
        this.hashTable = new BasicLinkedList[size];
        this.PN = 31;
        this.SIZE = size;
        this.keyCount = 0;
    }

    private int getHashCode(String str) {
        int key = 0, p = 1;

        for (char c : str.toCharArray()) {
            key += ((int) c) * p;
            p *= PN;
        }

        return Math.abs(key % SIZE);
    }

    private Pair searchByKey(BasicLinkedList<Pair> list, String key) {
        if (list == null) {
            return null;
        }

        BasicLinkedList<Pair>.Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair cur = (Pair) it.next();
            if (cur.getKey().equals(key)) {
                return cur;
            }
        }

        return null;
    }

    public void put(String key, String value) {
        int index = getHashCode(key);
        BasicLinkedList<Pair> list = hashTable[index];

        if (list == null) {
            list = new BasicLinkedList<Pair>();
            hashTable[index] = list;
        }

        Pair node = searchByKey(list, key);
        if (node == null) {
            list.addLast(new Pair(key, value));
            keyCount += 1;
        } else {
            node.setValue(value);
        }
    }

    public String get(String key) {
        int index = getHashCode(key);
        BasicLinkedList<Pair> list = hashTable[index];
        Pair node = searchByKey(list, key);
        if (node != null) {
            return node.getValue();
        } else {
            return null;
        }
    }

    public String remove(String key) {
        int index = getHashCode(key);
        BasicLinkedList<Pair> list = hashTable[index];
        Pair target = searchByKey(list, key);
        if (target != null) {
            list.remove(target);
            keyCount -= 1;
            return target.getValue();
        } else {
            return null;
        }
    }

    public int getSize() {
        return keyCount;
    }
}