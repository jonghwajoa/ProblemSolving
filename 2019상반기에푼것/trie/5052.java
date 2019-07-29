import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();

        while (repeat-- > 0) {
            Trie trie = new Trie();
            int N = sc.nextInt();
            String[] arr = new String[N];
            boolean flag = true;

            sc.nextLine();
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextLine();
                trie.insert(arr[i]);
            }

            for (int i = 0; i < N; i++) {
                if (!trie.find(arr[i])) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}

class Trie {
    Node head;

    class Node {
        boolean isEnd;
        Node[] next;

        public Node() {
            super();
            this.isEnd = false;
            this.next = new Node[10];
        }
    }

    public Trie() {
        super();
        this.head = new Node();
    }

    public void insert(final String str) {
        int len = str.length();

        Node cur = this.head;

        for (int i = 0; i < len; i++) {
            int index = Character.getNumericValue(str.charAt(i));

            if (cur.next[index] == null) {
                cur.next[index] = new Node();
            }
            cur = cur.next[index];
        }
        cur.isEnd = true;
    }

    public boolean find(final String str) {
        int len = str.length();

        Node cur = this.head;
        for (int i = 0; i < len; i++) {
            int index = Character.getNumericValue(str.charAt(i));

            if (cur.next[index] == null) {
                return false;
            }

            cur = cur.next[index];
            if (cur.isEnd && i != len - 1) {
                return false;
            }
        }
        return cur.isEnd;
    }
}
