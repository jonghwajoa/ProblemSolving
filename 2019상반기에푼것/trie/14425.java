import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            if (trie.find(br.readLine())) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}

class Trie {
    final int MAX_LEN = 26;
    Node head;

    class Node {
        boolean isEnd;
        Node[] next;

        public Node() {
            this.isEnd = false;
            this.next = new Node[MAX_LEN];
        }
    }

    public Trie() {
        super();
        this.head = new Node();
    }

    public void insert(final String str) {
        int len = str.length();

        Node cur = head;
        for (int i = 0; i < len; i++) {
            int index = str.charAt(i) - 'a';

            if (cur.next[index] == null) {
                cur.next[index] = new Node();
            }

            cur = cur.next[index];
        }
        cur.isEnd = true;
    }

    public boolean find(final String str) {
        int len = str.length();

        Node cur = head;
        for (int i = 0; i < len; i++) {
            int index = str.charAt(i) - 'a';

            if (cur.next[index] == null) {
                return false;
            }
            cur = cur.next[index];
        }
        return cur.isEnd;
    }
}
