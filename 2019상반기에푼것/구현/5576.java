import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] w = new int[10];
        int[] k = new int[10];

        for (int i = 0; i < 10; i++) {
            w[i] = sc.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            k[i] = sc.nextInt();
        }

        Arrays.sort(w);
        Arrays.sort(k);

        int wSum = 0;
        int kSum = 0;

        for (int i = 7; i < 10; i++) {
            wSum += w[i];
            kSum += k[i];
        }

        System.out.println(wSum + " " + kSum);
    }
}
