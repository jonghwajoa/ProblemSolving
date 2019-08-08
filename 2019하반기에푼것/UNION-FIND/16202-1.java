
// 너무 느린버전...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    static Graph[] graphArr;
    static int turnScore;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        graphArr = new Graph[E];
        PriorityQueue<Graph> pq = new PriorityQueue<>(new Comparator<Graph>() {
            @Override
            public int compare(Graph o1, Graph o2) {
                // TODO Auto-generated method stub
                return o1.cost - o2.cost;
            }
        });

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int st = Integer.parseInt(input[0]) - 1;
            int ed = Integer.parseInt(input[1]) - 1;
            pq.add(new Graph(st, ed, i + 1));
        }

        for (int i = 0; i < E; i++) {
            graphArr[i] = pq.poll();
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < K; i++) {
            if (flag) {
                if (getMST(i, V, E)) {
                    sb.append(turnScore + " ");
                } else {
                    sb.append("0 ");
                }
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean getMST(int curTurn, int V, int E) {
        boolean[] isVisit = new boolean[V];
        ArrayList<Graph>[] list = new ArrayList[V];
        PriorityQueue<Graph> pq = new PriorityQueue<>(new Comparator<Graph>() {
            @Override
            public int compare(Graph o1, Graph o2) {
                // TODO Auto-generated method stub
                return o1.cost - o2.cost;
            }
        });

        for (int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = curTurn; i < E; i++) {
            Graph g = graphArr[i];

            list[g.st].add(g);
            list[g.ed].add(new Graph(g.ed, g.st, g.cost));
        }

        int start = 0;
        isVisit[0] = true;
        for (Graph cur : list[start]) {
            pq.add(cur);
        }

        turnScore = 0;
        while (!pq.isEmpty()) {
            Graph cur = pq.poll();
            if (!isVisit[cur.ed]) {
                isVisit[cur.ed] = true;
                turnScore += cur.cost;
                for (Graph g : list[cur.ed]) {
                    pq.add(g);
                }
            }
        }

        return checkAllVisit(isVisit);

    }

    public static boolean checkAllVisit(boolean[] isVisit) {
        for (boolean b : isVisit) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}

class Graph {
    int st;
    int ed;
    int cost;

    public Graph(int st, int ed, int cost) {
        this.st = st;
        this.ed = ed;
        this.cost = cost;
    }
}
