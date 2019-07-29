import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();

        while (repeat-- > 0) {
            int n = sc.nextInt(); // 지점의 수
            int m = sc.nextInt(); // 도로의 개수
            int w = sc.nextInt(); // 웜홀의 갯수

            int[] dist = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                dist[i] = Integer.MAX_VALUE;
            }

            ArrayList<Street> list = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                list.add(new Street(a, b, c));
                list.add(new Street(b, a, c));
            }

            for (int i = 0; i < w; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                list.add(new Street(a, b, -1 * c));
            }

            dist[1] = 0;
            boolean flag = false;
            for (int i = 1; i <= n; i++) {

                for (Street cur : list) {
                    int from = cur.s;
                    int to = cur.e;
                    int c = cur.c;

                    if (dist[from] != Integer.MAX_VALUE && dist[from] + c < dist[to]) {
                        dist[to] = dist[from] + c;

                        if (i == n) {
                            flag = true;
                        }
                    }
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}

class Street {
    int s;
    int e;
    int c;

    public Street(int s, int e, int c) {
        this.s = s;
        this.e = e;
        this.c = c;
    }
}