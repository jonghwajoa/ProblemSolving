import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();
        int cnt = 0;

        String line = null;
        while ((line = br.readLine()) != null) {
            trie.insert(line);
            cnt += 1;
        }

        trie.start(cnt);
    }
}

class Trie {
    StringBuilder sb;
    final int MAX_LEN = 128;
    Node head;

    class Node {
        Node[] next;
        boolean isEnd;
        int count;

        public Node() {
            this.next = new Node[MAX_LEN];
            this.isEnd = false;
            this.count = 0;
        }
    }

    public Trie() {
        head = new Node();
        sb = new StringBuilder();
    }

    public void insert(String str) {
        int len = str.length();
        Node cur = head;

        for (int i = 0; i < len; i++) {
            int index = str.charAt(i);

            if (cur.next[index] == null) {
                cur.next[index] = new Node();
            }
            cur = cur.next[index];
        }
        cur.count += 1;
        cur.isEnd = true;
    }

    public void start(int cnt) {
        tour(head, "", cnt);
        System.out.println(sb.toString());
    }

    private void tour(Node cur, String acc, int cnt) {
        if (cur.isEnd) {
            String cal = String.format("%.4f", 100 * ((double) cur.count / cnt));
            sb.append(acc + " " + cal + "\n");
        }

        for (int i = 0; i < MAX_LEN; i++) {
            if (cur.next[i] != null) {
                char charAt = (char) i;
                tour(cur.next[i], acc + charAt, cnt);
            }
        }
    }
}
