import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, diffMin;
    static int total;
    static int[] populations;
    static LinkedList<Integer> team1, team2;
    static ArrayList<Integer>[] list;
    static boolean[] isVisit;

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        populations = new int[N];

        total = 0;
        for (int i = 0; i < N; i++) {
            populations[i] = atoi(st.nextToken());
            total += populations[i];
        }

        list = new ArrayList[N];
        isVisit = new boolean[N];
        team1 = new LinkedList<>();
        team2 = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = atoi(st.nextToken());
            for (int j = 0; j < n; j++) {
                list[i].add(atoi(st.nextToken()) - 1);
            }
        }

        diffMin = Integer.MAX_VALUE;
        divide2Team(0);

        System.out.println(diffMin == Integer.MAX_VALUE ? -1 : diffMin);

    }

    public static void divide2Team(int index) {
        if (N <= index) {
            if (!isValidTeam()) {
                return;
            }
            calculate();
            return;
        }

        team1.add(index);
        divide2Team(index + 1);
        team1.removeLast();

        team2.add(index);
        divide2Team(index + 1);
        team2.removeLast();
    }

    public static void calculate() {
        int team1Sum = 0;
        for (int n : team1) {
            team1Sum += populations[n];
        }

        int team2Sum = total - team1Sum;
        int subAbs = Math.abs(team1Sum - team2Sum);

        if (subAbs < diffMin) {
            diffMin = subAbs;
        }
    }

    public static boolean isValidTeam() {
        if (team1.size() <= 0 || team2.size() <= 0) {
            return false;
        }

        if (!checkTeam(team1) || !checkTeam(team2)) {
            return false;
        }

        return true;
    }

    public static boolean checkTeam(LinkedList<Integer> team) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisit = new boolean[N];
        int length = team.size();

        int index = 0;
        int start = team.get(index);
        q.add(start);
        isVisit[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            boolean isContain = false;
            for (int i = 0; i < length; i++) {
                if (team.get(i) == cur) {
                    isContain = true;
                    break;
                }
            }

            if (!isContain) {
                continue;
            }

            for (int n : list[cur]) {
                if (!isVisit[n]) {
                    isVisit[n] = true;
                    q.add(n);
                }
            }
        }

        for (int n : team) {
            if (!isVisit[n]) {
                return false;
            }
        }

        return true;
    }

    public static int atoi(String string) {
        return Integer.parseInt(string);
    }
}