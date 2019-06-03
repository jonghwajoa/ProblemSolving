import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        long sum = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                map[y][x] = sc.nextInt();
                sum += map[y][x];
            }
        }

        int min = 1;
        int max = 10000000;
        long ans = Integer.MAX_VALUE;
        long aim = sum % 2 == 0 ? sum / 2 : sum / 2 + 1;
        if (aim == 0) {
            System.out.println(0);
            return;
        }

        while (min <= max) {
            int mid = (min + max) / 2;
            if (cal(mid, aim)) {
                if (mid < ans) {
                    ans = mid;
                }
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean cal(int stand, long aim) {
        long sum = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] != 0) {
                    if (map[y][x] < stand) {
                        sum += map[y][x];
                    } else {
                        sum += stand;
                    }
                }
            }
        }

        return aim <= sum;
    }
}
