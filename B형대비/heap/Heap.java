public class Heap {
    int[] array;
    final int MAX_SIZE;
    int size = 0;

    public Heap(int size) {
        this.MAX_SIZE = size + 1;
        this.array = new int[size];
    }

    public void push(int value) {
        array[++size] = value;
        int curIdx = size;
        while (array[curIdx] < array[curIdx / 2]) {
            int tmp = array[curIdx / 2];
            array[curIdx / 2] = array[curIdx];
            array[curIdx] = tmp;
            curIdx = curIdx / 2;
        }
    }

    public int pop() {
        if (size <= 0) {
            throw new OutOfMemoryError();
        }

        int remove = array[1];
        array[1] = array[size];
        array[size--] = Integer.MAX_VALUE;

        for (int i = 1; i * 2 <= size;) {
            if (array[i] < array[i * 2] && array[i] < array[i * 2 + 1]) {
                break;
            } else if (array[i * 2] < array[i * 2 + 1]) {
                int tmp = array[i];
                array[i] = array[i * 2];
                array[i * 2] = tmp;
                i *= 2;
            } else {
                int tmp = array[i];
                array[i] = array[i * 2 + 1];
                array[i * 2 + 1] = tmp;
                i = i * 2 + 1;
            }
        }
        return remove;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(array[i] + ", ");
        }
        sb.append(array[size] + "]");
        System.out.println(sb.toString());
    }
}
