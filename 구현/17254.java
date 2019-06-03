import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.nextLine();
        PriorityQueue<Key> pq = new PriorityQueue<>(new keyOrder());
        for (int i = 0; i < M; i++) {
            String[] line = sc.nextLine().split(" ");
            pq.add(new Key(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2].charAt(0)));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll().k);
        }
        System.out.println(sb.toString());
    }
}

class Key {
    int id;
    int s;
    char k;

    public Key(int id, int s, char k) {
        super();
        this.id = id;
        this.s = s;
        this.k = k;
    }
}

class keyOrder implements Comparator<Key> {
    @Override
    public int compare(Key o1, Key o2) {
        if (o1.s == o2.s) {
            return o1.id - o2.id;
        }
        return o1.s - o2.s;
    }
}
