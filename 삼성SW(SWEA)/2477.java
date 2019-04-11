
// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV6c6bgaIuoDFAXy&categoryId=AV6c6bgaIuoDFAXy&categoryType=CODE
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    final static int[] available = new int[6];

    static int RECEPTON_COUNT, REPAIR_COUNT;
    static int VISIT_COUNT;
    static int[] ai, bi, ci;
    static int useReceptionNo, useRepairNo, ans;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc++) {
            RECEPTON_COUNT = sc.nextInt();
            REPAIR_COUNT = sc.nextInt();
            VISIT_COUNT = sc.nextInt();
            useReceptionNo = sc.nextInt() - 1;
            useRepairNo = sc.nextInt() - 1;
            ans = 0;

            ai = new int[RECEPTON_COUNT];
            bi = new int[REPAIR_COUNT];
            ci = new int[VISIT_COUNT];

            for (int i = 0; i < RECEPTON_COUNT; i++) {
                ai[i] = sc.nextInt();
            }

            for (int i = 0; i < REPAIR_COUNT; i++) {
                bi[i] = sc.nextInt();
            }

            for (int i = 0; i < VISIT_COUNT; i++) {
                ci[i] = sc.nextInt();
            }

            solve();
            if (ans == 0) {
                ans = -1;
            }
            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void solve() {

        PriorityQueue<Customer> repairUse = new PriorityQueue<>(new RepairOrder());
        PriorityQueue<Customer> repairWait = new PriorityQueue<>(new RepairWaitOrder());
        PriorityQueue<Customer> receptionUse = new PriorityQueue<>(new RepairOrder());
        PriorityQueue<Customer> receptionWait = new PriorityQueue<>(new ReceptionWaitOrde());
        boolean[] useRepair = new boolean[REPAIR_COUNT];
        boolean[] useReception = new boolean[RECEPTON_COUNT];

        int count = 0;
        int curTime = 0;
        int lastIndex = 0;
        while (count < VISIT_COUNT) {
            // 정비소에서 다고쳤으면 나가!
            while (!repairUse.isEmpty()) {
                if (repairUse.peek().time <= curTime) {
                    Customer remove = repairUse.poll();
                    useRepair[remove.repairNo] = false;

                    if (remove.receptionNo == useReceptionNo && remove.repairNo == useRepairNo) {
                        ans += remove.customerNo;
                    }
                    count++;
                } else {
                    break;
                }
            }

            // 접수했으면 정비소들어가기전에 대기하세요!!
            while (!receptionUse.isEmpty()) {
                if (receptionUse.peek().time <= curTime) {
                    Customer remove = receptionUse.poll();
                    useReception[remove.receptionNo] = false;
                    repairWait.add(remove);
                } else {
                    break;
                }
            }

            // 빈 정비소에 들어가세요!!
            for (int i = 0; i < REPAIR_COUNT; i++) {
                if (!repairWait.isEmpty() && useRepair[i] == false) {
                    Customer cur = repairWait.poll();
                    cur.repairNo = i;
                    cur.time = curTime + bi[i];
                    useRepair[i] = true;
                    repairUse.add(cur);
                }
            }

            // 병원 도착해서 접수 가능자
            for (int i = lastIndex; i < VISIT_COUNT; i++) {
                if (ci[i] <= curTime) {
                    lastIndex = i + 1;
                    receptionWait.add(new Customer(lastIndex, -1, -1, -1));
                } else {
                    break;
                }
            }

            // 접수 예약자는 예약하러 들어가세요.!!
            for (int i = 0; i < RECEPTON_COUNT; i++) {
                if (!receptionWait.isEmpty() && useReception[i] == false) {
                    useReception[i] = true;
                    Customer remove = receptionWait.poll();
                    remove.receptionNo = i;
                    remove.time = curTime + ai[i];
                    receptionUse.add(remove);
                }
            }

            curTime += 1;
        }
    }
}

class RepairOrder implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.time - o2.time;
    }

}

class ReceptionWaitOrde implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.customerNo - o2.customerNo;
    }

}

class RepairWaitOrder implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.time == o2.time) {
            return o1.receptionNo - o2.receptionNo;
        }
        return o1.time - o2.time;
    }

}

class Customer {
    int customerNo;
    int receptionNo;
    int repairNo;
    int time;

    public Customer(int customerNo, int receptionNo, int repairNo, int time) {
        this.customerNo = customerNo;
        this.receptionNo = receptionNo;
        this.repairNo = repairNo;
        this.time = time;
    }
}