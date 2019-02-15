import java.util.Scanner;

public class Mine {
    static char[][] map;
    static int ans = Integer.MAX_VALUE;
    static char[][] blackFirstBoard = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };

    static char[][] whiteFirstBoard = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] inputLine = sc.nextLine().split(" ");
        int y = Integer.parseInt(inputLine[0]);
        int x = Integer.parseInt(inputLine[1]);

        map = new char[y][x];
        for (int i = 0; i < y; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i <= y - 8; i++) {
            for (int j = 0; j <= x - 8; j++) {
                int min = Math.min(compareBlackFirst(j, i), compareWriteFirst(j, i));
                if (min < ans) {
                    ans = min;
                }

            }
        }
        System.out.println(ans);
    }

    public static int compareBlackFirst(int x, int y) {
        int count = 0;
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (map[i][j] != blackFirstBoard[i - y][j - x]) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static int compareWriteFirst(int x, int y) {
        int count = 0;
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (map[i][j] != whiteFirstBoard[i - y][j - x]) {
                    count += 1;
                }
            }
        }
        return count;
    }

}
