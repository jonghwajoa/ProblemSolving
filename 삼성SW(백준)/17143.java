import java.util.Scanner;

public class Solution {
    final static int[] mx = { 0, 0, 0, 1, -1 };
    final static int[] my = { 0, -1, 1, 0, 0 };
    static int UP = 1, DOWN = 2, RIGHT = 3, LEFT = 4;
    static int NY, NX, M;
    static Fish[] fish;
    static int[] fishIndex;
    static int[][] map;
    static int ans;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        NY = sc.nextInt();
        NX = sc.nextInt();
        M = sc.nextInt();
        fish = new Fish[M + 1];
        fishIndex = new int[10001];
        map = new int[NY][NX];
        ans = 0;

        for (int i = 1; i <= M; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();
            fishIndex[z] = i;
            fish[i] = new Fish(x, y, s, d, z);
            map[y][x] = z;
        }

        for (int x = 0; x < NX; x += 1) {
            fishing(x);

            if (x == NX - 1) {
                break;
            }
            fishMove();
        }

        System.out.println(ans);
    }

    public static void fishMove() {
        int[][] nextMap = new int[NY][NX];

        for (int i = 1; i <= M; i++) {
            if (fish[i] == null) {
                continue;
            }

            Fish cur = fish[i];
            int remain = cur.s;
            if (cur.d == UP || cur.d == DOWN) {
                while (true) {
                    int checkY = cur.y + (my[cur.d] * remain);
                    if (checkY < 0 || checkY >= NY) {
                        if (cur.d == UP) {
                            remain -= cur.y;
                            cur.y = 0;
                        } else {
                            remain = remain - (NY - 1 - cur.y);
                            cur.y = NY - 1;
                        }
                        cur.d = reverseDirection(cur.d);
                    } else {
                        cur.y = checkY;
                        if (cur.y == 0 || cur.y == NY - 1) {
                            cur.d = reverseDirection(cur.d);
                        }
                        break;
                    }
                }
            } else {
                while (true) {
                    int checkX = cur.x + (mx[cur.d] * remain);
                    if (checkX < 0 || checkX >= NX) {
                        if (cur.d == RIGHT) {
                            remain = remain - (NX - 1 - cur.x);
                            cur.x = NX - 1;
                        } else {
                            remain -= cur.x;
                            cur.x = 0;
                        }
                        cur.d = reverseDirection(cur.d);
                    } else {
                        cur.x = checkX;
                        if (cur.x == 0 || cur.x == NX - 1) {
                            cur.d = reverseDirection(cur.d);
                        }
                        break;
                    }
                }
            }

            if (nextMap[cur.y][cur.x] < cur.z) {
                int index = fishIndex[nextMap[cur.y][cur.x]];
                fish[index] = null;
                nextMap[cur.y][cur.x] = cur.z;
            } else {
                int index = fishIndex[cur.z];
                fish[index] = null;
            }
        }
        map = nextMap;

    }

    public static void fishing(int x) {
        for (int y = 0; y < NY; y += 1) {
            if (map[y][x] > 0) {
                int size = map[y][x];
                ans += size;
                map[y][x] = 0;
                int index = fishIndex[size];
                fish[index] = null;
                break;
            }
        }
    }

    public static int reverseDirection(int d) {
        if (d == UP) {
            return DOWN;
        } else if (d == DOWN) {
            return UP;
        } else if (d == RIGHT) {
            return LEFT;
        } else {
            return RIGHT;
        }
    }
}

class Fish {
    int x;
    int y;
    int s;
    int d;
    int z;

    public Fish(int x, int y, int s, int d, int z) {
        super();
        this.x = x;
        this.y = y;
        this.s = s;
        this.d = d;
        this.z = z;
    }

}