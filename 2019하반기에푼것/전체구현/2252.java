import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int[] fasterThenMeCnt = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            fasterThenMeCnt[b] += 1;
        }

        LinkedList<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++) {
            if (fasterThenMeCnt[i] == 0) {
                q.addLast(i);
            }
        }

        StringBuilder ansSB = new StringBuilder();
        while (!q.isEmpty()) {
            int curN = q.poll();
            ansSB.append(curN + " ");

            int len = list[curN].size();
            for (int i = 0; i < len; i++) {
                int n = list[curN].get(i);
                fasterThenMeCnt[n] -= 1;
                if (fasterThenMeCnt[n] == 0) {
                    q.addLast(n);
                }
            }
        }
        System.out.println(ansSB);
    }
}

class LinkedList<T> {
    private Node head, tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private class Node {
        T data;
        Node next, prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
        this.size += 1;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        this.size += 1;
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public T removeFirst() {
        Node remove = head;
        if (this.size == 1) {
            head = null;
            tail = null;
        } else {
            Node next = head.next;
            next.prev = null;
            head.next = null;
            head = next;
        }
        this.size -= 1;
        return remove.data;
    }

    public T poll() {
        return removeFirst();
    }
}

class ArrayList<T> {
    private Object[] arr;
    private int size;
    private int idx = 0;

    public ArrayList() {
        this.size = 10;
        this.arr = (T[]) new Object[10];
    }

    public ArrayList(int size) {
        this.arr = (T[]) new Object[size];
        this.size = size;
    }

    public void add(T data) {
        if (size <= idx) {
            extendCapacaty();
        }

        this.arr[idx++] = data;
    }

    private void extendCapacaty() {
        int ensureSize = size * 2;
        Object[] tmp = (T[]) new Object[ensureSize];
        for (int i = 0; i < size; i++) {
            tmp[i] = this.arr[i];
        }
        this.size = ensureSize;
        this.arr = tmp;
    }

    public T get(int idx) {
        return (T) this.arr[idx];
    }

    public int size() {
        return this.idx;
    }
}