import java.util.*;

public class Main {
    static int[] moveX = { 0, 0, 1, -1 };
    static int[] moveY = { 1, -1, 0, 0 };
    static boolean[][][] isVisit;
    static int[][] map;
    static int mapX, mapY;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");

        mapY = Integer.parseInt(line[0]);
        mapX = Integer.parseInt(line[1]);
        map = new int[mapY][mapX];
        isVisit = new boolean[2][mapY][mapX];

        for (int i = 0; i < mapY; i++) {
            line = sc.nextLine().split("");
            for (int j = 0; j < mapX; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, false));
        isVisit[0][0][0] = true;
        isVisit[1][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dist = cur.dist;

            if (x == mapX - 1 && y == mapY - 1) {
                if (dist < ans) {
                    ans = dist;
                }
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + moveX[i];
                int nextY = y + moveY[i];

                if (0 <= nextX && 0 <= nextY && nextX < mapX && nextY < mapY) {

                    if (map[nextY][nextX] == 1) {
                        if (!cur.check && !isVisit[1][nextY][nextX]) {
                            q.add(new Node(nextX, nextY, dist + 1, true));
                            isVisit[1][nextY][nextX] = true;
                        }
                    } else {
                        if (!cur.check && !isVisit[0][nextY][nextX]) {
                            isVisit[0][nextY][nextX] = true;
                            q.add(new Node(nextX, nextY, dist + 1, false));
                        } else if (cur.check && !isVisit[1][nextY][nextX]) {
                            isVisit[1][nextY][nextX] = true;
                            q.add(new Node(nextX, nextY, dist + 1, true));
                        }
                    }
                }
            }
        }

        if (ans == Integer.MAX_VALUE)

        {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}

class Node {
    int x;
    int y;
    int dist;
    boolean check;

    public Node(int x, int y, int dist, boolean check) {
        super();
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.check = check;
    }
}
