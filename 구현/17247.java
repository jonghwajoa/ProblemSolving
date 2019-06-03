import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int Y = sc.nextInt();
        int X = sc.nextInt();

        int[][] map = new int[Y][X];
        Point[] list = new Point[2];

        int index = 0;
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (1 == sc.nextInt()) {
                    list[index++] = new Point(x, y);
                }
            }
        }

        Point start = list[0];
        Point end = list[1];

        int diff = Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
        System.out.println(diff);
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