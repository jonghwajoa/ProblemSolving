// 바이너리 서치 vs 해시
// 정렬해야하면 : 해시가빠름
// 이미 정렬되어있음 : 바이너리 서치가 빠름

// 해시 : 검색을빠르게 하기 위한 자료구조이나 많은저장공간이 필요함

/*
 * 어떤 데이터를 언제 변환하여도 항상 같은 값으로 표현되는 값. 좋은 성능을 내기위해서는 임의의 어떤 데이터를 key로 변환할때, key가
 * 균등하게 배분되어야 함.
 * 
 */

public class Main {
    public static int PN = 31;
    public static int HASH_SIZE = 5;

    public static void main(String args[]) throws Exception {
        BasicLinkedList list = new BasicLinkedList();
        java.util.LinkedList<Integer> list2 = new java.util.LinkedList<>();

        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.addFirst(i);
        }

        for (int i = 0; i < 10000; i++) {
            list.addLast(i);
        }

        for (int i = 0; i < 50000; i++) {
            list.insert(i, i);
        }
        System.out.println((System.currentTimeMillis() - start) / 1000.0);

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list2.addFirst(i);
        }

        for (int i = 0; i < 10000; i++) {
            list2.addLast(i);
        }

        for (int i = 0; i < 50000; i++) {
            list2.add(i, i);
        }
        System.out.println((System.currentTimeMillis() - start) / 1000.0);

    }

    public static Long get_key(String str) {
        Long key = 0L, p = 1L;
        for (int i = 0; i < str.length(); i += 1) {
            key += (str.charAt(i) * p);
            p *= PN;
        }
        return key % HASH_SIZE;
    }
}

class BasicLinkedList {
    private int size;
    private Node head, tail;

    public BasicLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    class Node {
        int val;
        Node next, prev;

        public Node(int value) {
            this.val = value;
        }

        public String toString() {
            return "" + val;
        }
    }

    public int getSize() {
        return size;
    }

    public int getFirstValue() {
        return head.val;
    }

    public int getLastValue() {
        return tail.val;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size += 1;
        if (tail == null) {
            tail = newNode;
        }
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size += 1;

        if (head == null) {
            head = newNode;
        }
    }

    public void insert(int index, int value) {
        if (size <= index - 1) {
            addLast(value);
            return;
        }

        Node cur = move(index - 1);
        Node newNode = new Node(value);
        newNode.prev = cur;
        newNode.next = cur.next;
        cur.next = newNode;

        if (size == index) {
            tail = newNode;
        }
        size += 1;
    }

    public int getFirst() {
        return head.val;
    }

    public int getLast() {
        return tail.val;
    }

    public int get(int index) {
        if (size <= index - 1) {
            index = size;
        }
        return move(index).val;
    }

    private Node move(int index) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node cur = head;
        for (int i = 0; i < size - 1; i++) {
            sb.append(cur.val + ", ");
            cur = cur.next;
        }
        sb.append(cur.val + "]");
        return sb.toString();
    }
}
