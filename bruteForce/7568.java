import java.util.*;

public class Main {
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        map = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            findOrder(i, n);
        }
    }

    public static void findOrder(int curIndex, int maxN) {
        int myWeight = map[curIndex][0];
        int myHeight = map[curIndex][1];
        int count = 0;
        for (int i = 0; i < maxN; i++) {
            if (i != curIndex) {
                int compareWeight = map[i][0];
                int compareHeight = map[i][1];

                if (myWeight < compareWeight && myHeight < compareHeight) {
                    count += 1;
                }
            }
        }
        System.out.print(count + 1 + " ");
    }
}
