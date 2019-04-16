class BasicLinkedList<T> {
    private Node head, tail;
    private int size;

    class Node {
        Node prev;
        Node next;
        T data;

        public Node(T data) {
            this.prev = null;
            this.next = null;
            this.data = data;
        }
    }

    public BasicLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public Node move(int index) {
        if (size <= index) {
            return tail;
        }

        Node cur;
        if (index < size / 2) {
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = size - 1; index < i; i--) {
                cur = cur.prev;
            }
        }
        return cur;
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void addLast(T data) {
        if (size == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void add(int index, T data) {
        if (index >= size) {
            addLast(data);
            return;
        } else if (index == 0) {
            addFirst(data);
            return;
        }

        Node nextNode = move(index);
        Node prevNode = nextNode.prev;
        Node newNode = new Node(data);

        newNode.next = nextNode;
        newNode.prev = prevNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;
        size++;
    }

    public T removeFirst() {
        Node remove = head;
        head = remove.next;
        size--;
        return remove.data;
    }

    public T removeLast() {
        Node remove = tail;
        tail = remove.prev;
        size--;
        return remove.data;
    }

    public T remove(int index) {
        Node target = move(index);
        target.prev.next = target.next;
        target.next.prev = target.prev;
        return target.data;
    }

    public boolean remove(Object target) {
        Node cur = head;

        for (int i = 0; i < size; i++) {
            if (cur.data.equals(target)) {
                if (i == 0) {
                    removeFirst();
                    return true;
                } else if (i == size - 1) {
                    removeLast();
                    return true;
                } else {
                    Node prev = cur.prev;
                    Node next = cur.next;
                    prev.next = next;
                    next.prev = prev;
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();

        Node cur = head;
        sb.append("[");
        while (cur.next != null) {
            sb.append(cur.data + ", ");
            cur = cur.next;
        }
        sb.append(cur.data + "]");
        return sb.toString();
    }

    class Iterator {
        private Node next;
        private Node curNode;
        private int nextIndex;

        public Iterator() {
            next = head;
            nextIndex = 0;
        }

        public T next() {
            curNode = next;
            next = next.next;
            nextIndex++;
            return curNode.data;
        }

        public boolean hasNext() {
            if (nextIndex < size) {
                return true;
            } else {
                return false;
            }
        }
    }

    public Iterator iterator() {
        return new Iterator();
    }
}
