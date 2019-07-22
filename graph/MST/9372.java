import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            ans = 0;
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            parent = new int[N + 1];

            for (int z = 1; z <= N; z++) {
                parent[z] = z;
            }

            for (int z = 0; z < M; z++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                if (a > b) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }

                if (union(a, b)) {
                    ans += 1;
                }
            }

            System.out.println(ans);
        }
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
            return true;
        }
        return false;
    }
}

class Flight {
    int st;
    int ed;

    public Flight(int st, int ed) {
        super();
        this.st = st;
        this.ed = ed;
    }
}
