import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String next = null;

        while ((next = br.readLine()) != null) {
            int N = Integer.parseInt(next);

            String[] str = new String[N];
            Trie trie = new Trie();

            for (int i = 0; i < N; i++) {
                str[i] = br.readLine();
                trie.insert(str[i]);
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += trie.find(str[i]);
            }
            System.out.println(String.format("%.2f", (double) cnt / N));
        }

    }
}

class Trie {
    final int MAX_LEN = 26;
    Node head;

    class Node {
        Node[] next;
        boolean isEnd;
        int cnt;

        public Node() {
            this.next = new Node[MAX_LEN];
            this.isEnd = false;
            this.cnt = 0;
        }
    }

    public Trie() {
        this.head = new Node();
    }

    public void insert(String str) {
        Node cur = head;
        int len = str.length();

        for (int i = 0; i < len; i++) {
            int index = str.charAt(i) - 'a';
            if (cur.next[index] == null) {
                cur.next[index] = new Node();
                cur.cnt += 1;
            }
            cur = cur.next[index];
        }
        cur.isEnd = true;
    }

    public int find(String str) {
        int len = str.length();
        int count = 0;

        Node cur = head;
        for (int i = 0; i < len; i++) {
            int index = str.charAt(i) - 'a';
            cur = cur.next[index];
            if (cur.cnt > 1 || cur.isEnd) {
                count += 1;
            }
        }
        return count;
    }
}
