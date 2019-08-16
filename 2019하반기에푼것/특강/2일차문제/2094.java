import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    static int N;
    static Rainfall[] rainfall;
    static int[] rankArr;

    public static void main(String[] argv) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        rainfall = new Rainfall[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            rainfall[i] = new Rainfall(y, a);
        }

        Arrays.sort(rainfall);
        rankArr = new int[N];
        for (int i = 0; i < N; i++) {
            rainfall[i].rank = i;
            rankArr[i] = rainfall[i].year;
        }

        // 바이너리 서치하기위해 year로 재정렬
        Arrays.sort(rainfall, new OrderByYear());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int standardY = Integer.parseInt(st.nextToken());
            int tagetY = Integer.parseInt(st.nextToken());
            int standardIdx = getYearIdx(standardY);
            int targetIdx = getYearIdx(tagetY);

            int stRank = rainfall[standardIdx].rank;
            int taRank = rainfall[targetIdx].rank;
            boolean isTrue = false;
            // 1. Y년도, X년도, 그리고 그 사이의 모든 년도들의 강수량에 대한 정보가 알려져 있다.
            if (tagetY - standardY == targetIdx - standardIdx) {

            }

            // 2.X년도의 강수량은 Y년도의 강수량 이하이다.
            if (taRank < stRank) {
                // 3. Y < Z < X를 만족하는 모든 Z들에 대해서, Z년도의 강수량은 X년도보다 적다.
                if (isMaxAmountInSection(standardY, tagetY, taRank)) {
                    if (tagetY - standardY == targetIdx - standardIdx) {
                        bw.write("true\n");
                        continue;
                    }
                    bw.write("maybe\n");
                    continue;
                }
                bw.write("false\n");
            } else {
                bw.write("false\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static boolean isMaxAmountInSection(int standardYear, int targetYear, int targetRank) {
        for (int i = standardYear + 1; i < targetYear; i++) {
            int idx = getYearIdx(i);
            if (targetRank < rainfall[idx].rank) {
                return false;
            }
        }
        return true;
    }

    public static int getYearIdx(int targetYear) {
        int l = 0;
        int r = N - 1;
        int idx = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (rainfall[mid].year == targetYear) {
                idx = mid;
                break;
            } else if (rainfall[mid].year < targetYear) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return idx;
    }
}

class OrderByYear implements Comparator<Rainfall> {
    @Override
    public int compare(Rainfall o1, Rainfall o2) {
        return o1.year - o2.year;
    }
};

class Rainfall implements Comparable<Rainfall> {
    int year;
    int amount;
    int rank = -1;

    public Rainfall(int year, int amount) {
        this.year = year;
        this.amount = amount;
    }

    @Override
    public int compareTo(Rainfall o) {
        if (this.amount == o.amount) {
            return this.year - o.year;
        }
        return this.amount - o.amount;
    }
}
