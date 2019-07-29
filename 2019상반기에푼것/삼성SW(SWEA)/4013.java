// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH&categoryId=AWIeV9sKkcoDFAVH&categoryType=CODE&&&

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    final static LinkedList<Integer>[] wheel = new LinkedList[4];
    static Queue<Turn> order;
    final static int RIGHT_INDEX = 2, LEFT_INDEX = 6;
    final static int GO = 1, BACK = -1;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc++) {
            int N = sc.nextInt();
            order = new LinkedList<>();

            for (int i = 0; i < 4; i++) {
                wheel[i] = new LinkedList();
                for (int j = 0; j < 8; j++) {
                    wheel[i].add(sc.nextInt());
                }
            }

            for (int i = 0; i < N; i++) {
                int index = sc.nextInt() - 1;
                int direction = sc.nextInt();
                order.add(new Turn(index, direction));
            }

            solve();

            int ans = 0;
            for (int i = 0; i < 4; i++) {
                if (wheel[i].getFirst() == 1) {
                    ans += Math.pow(2, i);
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void solve() {

        while (!order.isEmpty()) {
            Turn cur = order.poll();

            int prevRight = wheel[cur.index].get(RIGHT_INDEX);
            int prevLeft = wheel[cur.index].get(LEFT_INDEX);
            int lastD = cur.direction;
            for (int i = cur.index + 1; i < 4; i++) {
                if (prevRight == wheel[i].get(LEFT_INDEX)) {
                    break;
                }
                lastD = reverseD(lastD);
                prevRight = wheel[i].get(RIGHT_INDEX);
                nextWheel(i, lastD);
            }

            lastD = cur.direction;

            for (int i = cur.index - 1; 0 <= i; i--) {
                if (prevLeft == wheel[i].get(RIGHT_INDEX)) {
                    break;
                }
                lastD = reverseD(lastD);
                prevLeft = wheel[i].get(LEFT_INDEX);
                nextWheel(i, lastD);
            }

            nextWheel(cur.index, cur.direction);
        }
    }

    public static void nextWheel(int index, int direction) {
        if (direction == 1) {
            wheel[index].addFirst(wheel[index].removeLast());
        } else {
            wheel[index].addLast(wheel[index].removeFirst());
        }
    }

    public static int reverseD(int curD) {
        return curD == 1 ? -1 : 1;
    }
}

class Turn {
    int index;
    int direction;

    public Turn(int index, int direction) {
        this.index = index;
        this.direction = direction;
    }
}
