import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer>[] list = new LinkedList[N + 1];
        int[] p = new int[N + 1];
        int[] d = new int[N + 1];
        boolean[] isVisit = new boolean[N + 1];

        final int INF = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            list[i] = new LinkedList<>();
            p[i] = i;
            d[i] = INF;
        }

        final int ROOT = 1;
        d[ROOT] = 0;
        isVisit[ROOT] = true;

        String[] readLine = null;
        for (int i = 0; i < N - 1; i++) {
            readLine = br.readLine().split("\\s+");
            int a = Integer.parseInt(readLine[0]);
            int b = Integer.parseInt(readLine[1]);
            list[a].add(b);
            list[b].add(a);
        }

        Queue q = new Queue();
        q.add(ROOT);

        while (!q.isEmpty()) {
            int cur = q.pop();
            LinkedList<Integer>.Node head = list[cur].head;
            while (head != null) {
                int n = (int) head.data;
                if (!isVisit[n]) {
                    isVisit[n] = true;
                    q.add(n);
                    p[n] = cur;
                    d[n] = d[cur] + 1;
                }
                head = head.next;
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            readLine = br.readLine().split("\\s+");
            int a = Integer.parseInt(readLine[0]);
            int b = Integer.parseInt(readLine[1]);

            if (d[a] > d[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            while (d[a] != d[b]) {
                b = p[b];
            }

            while (a != b) {
                a = p[a];
                b = p[b];
            }
            sb.append(a + "\n");
        }
        System.out.println(sb.toString());
    }
}

class Queue {
    int[] arr = new int[10000];
    int idx = 0;

    public void add(int i) {
        arr[idx++] = i;
    }

    public int pop() {
        return arr[--idx];
    }

    public boolean isEmpty() {
        return idx == 0;
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
        super();
        this.head = null;
        this.tail = null;
        this.size = 0;
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
        size += 1;
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

        size += 1;
    }

    public void add(T data) {
        addLast(data);
    }

}
