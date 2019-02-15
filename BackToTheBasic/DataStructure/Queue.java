import java.util.LinkedList;
import java.util.Queue;

public class Que {

    public static void main(String[] args) {

        Queue<Integer> que = new Queue<Integer>();
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);

        System.out.println(que.toString());

        que.remove();
        que.remove();
        que.remove();
        System.out.println(que.toString());

    }
}

class Queue<T> {
    LinkedList<T> list;
    StringBuilder sb;

    public Queue() {
        super();
        this.list = new LinkedList<T>();
        sb = new StringBuilder();
    }

    public void add(T e) {
        list.add(e);
    }

    public T remove() {
        return list.remove();
    }

    public T peek() {
        return list.getFirst();
    }

    public Integer size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0 ? true : false;
    }

    @Override
    public String toString() {
        int len = list.size();

        sb.append("[");
        for (int i = 0; i < len - 1; i++) {
            sb.append(list.get(i) + ", ");
        }
        sb.append(list.get(len - 1) + "]");
        String string = sb.toString();
        sb.setLength(0);
        return string;
    }
}
