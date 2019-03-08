import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] childCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        childCount = new int[n];
        list = new ArrayList[n];

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        int root;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input != -1) {
                childCount[input] += 1;
                list[input].add(i);
            }
            parent[i] = input;
        }

        int delete = sc.nextInt();
        dfs(delete);

        if (parent[delete] != -1) {
            childCount[parent[delete]] -= 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (childCount[i] == 0) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }

    public static void dfs(int idx) {
        childCount[idx] = Integer.MAX_VALUE;
        for (int e : list[idx]) {
            dfs(e);
        }
    }
}
