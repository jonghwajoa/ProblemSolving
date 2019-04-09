
// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5-BEE6AK0DFAVl&categoryId=AV5-BEE6AK0DFAVl&categoryType=CODE&&&

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    final static int[] mx = { 0, 1, 0, -1 };
    final static int[] my = { -1, 0, 1, 0 };

    static int N;
    static int[][] map;

    static LinkedList<Point> person;
    static LinkedList<Stair> stair;
    static int STAIR_COUNT = 2, ans;
    static int PERSON_COUNT;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc += 1) {
            N = sc.nextInt();
            map = new int[N][N];
            person = new LinkedList<>();
            stair = new LinkedList<>();
            ans = Integer.MAX_VALUE;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    int tmp = sc.nextInt();
                    if (tmp == 1) {
                        person.add(new Point(x, y));
                    } else if (tmp >= 2) {
                        stair.add(new Stair(x, y, tmp));
                    }
                }
            }
            LinkedList<Integer> order = new LinkedList<>();
            PERSON_COUNT = person.size();
            dfs(0, order);

            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void dfs(int step, LinkedList<Integer> order) {
        if (step >= PERSON_COUNT) {
            cal(order);
            return;
        }

        for (int i = 0; i < STAIR_COUNT; i++) {
            order.add(i);
            dfs(step + 1, order);
            order.removeLast();
        }
    }
    // 계단에는 최대 3명만 갈수있음..
    // 계단의 길이만큼 걸림

    public static void cal(LinkedList<Integer> order) {
        Queue<Integer>[] use = new LinkedList[STAIR_COUNT];
        for (int i = 0; i < STAIR_COUNT; i++) {
            use[i] = new LinkedList<>();
        }
        int[] wait = new int[STAIR_COUNT];
        PriorityQueue<Pair> reach = new PriorityQueue<>(new PairOrder());

        int len = person.size();
        for (int i = 0; i < len; i++) {
            Point curP = person.get(i);
            Point curS = stair.get(order.get(i));
            int abs = Math.abs(curP.x - curS.x) + Math.abs(curP.y - curS.y);
            reach.add(new Pair(abs, order.get(i)));
        }

        int time = 1;
        int count = 0;
        int personSize = person.size();
        while (count < personSize) {
            for (int i = 0; i < STAIR_COUNT; i++) {
                if (use[i].isEmpty()) {
                    continue;
                }
                while (!use[i].isEmpty()) {
                    if (use[i].peek() > time) {
                        break;
                    }
                    use[i].poll();
                    count += 1;
                }
            }

            // 계단에 입장!!
            for (int i = 0; i < STAIR_COUNT; i++) {
                while (use[i].size() < 3 && 0 < wait[i]) {
                    use[i].add(time + stair.get(i).time);
                    wait[i]--;
                }
            }

            // 계단으로 이동
            len = reach.size();
            for (int i = 0; i < len; i++) {
                if (time < reach.peek().abs) {
                    break;
                }
                Pair cur = reach.poll();
                wait[cur.no] += 1;
            }

            time += 1;
        }

        time--;

        if (time < ans) {
            ans = time;
        }
    }
}

class PairOrder implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.abs - o2.abs;
    }

}

class Pair {
    int abs;
    int no;

    public Pair(int abs, int no) {
        this.abs = abs;
        this.no = no;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}

class Stair extends Point {
    int time;

    public Stair(int x, int y, int time) {
        super(x, y);
        this.time = time;
    }
}