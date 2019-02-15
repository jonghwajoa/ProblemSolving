import java.util.*;

public class simulation {

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        Pair[] score = new Pair[8];

        for (int i = 0; i < 8; i++) {
            score[i] = new Pair(sc.nextInt(), i + 1);
        }

        Arrays.sort(score);

        int acc = 0;
        int[] ans = new int[5];
        for (int i = 0; i < 5; i++) {
            acc += score[i].score;
            ans[i] = score[i].index;
        }
        Arrays.sort(ans);
        System.out.println(acc);
        for (int e : ans) {
            System.out.print(e + " ");
        }
    }
}

class Pair implements Comparable<Pair> {
    int score;
    int index;

    public Pair(int score, int index) {
        super();
        this.score = score;
        this.index = index;
    }

    @Override
    public int compareTo(Pair o) {
        return o.score - this.score;
    }

}