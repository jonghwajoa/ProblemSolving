
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[] isVisit;
    static ArrayList<Integer>[] a;

    public static void main(String args[]) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int repeat = sc.nextInt();
    	int count = 0;
    	isVisit = new boolean[n + 1];

    	a = (ArrayList<Integer>[]) new ArrayList[n + 1];

    	for (int i = 1; i <= n; i++) {
    		a[i] = new ArrayList<Integer>();
    	}

    	for (int i = 0; i < repeat; i++) {
    		int u = sc.nextInt();
    		int v = sc.nextInt();
    		a[u].add(v);
    		a[v].add(u);
    	}

    	for (int i = 1; i <= n; i++) {
    		if(!isVisit[i]) {
    			count++;
    			//bfs(i);
    			dfs(i);
    		}
    	}
    	System.out.println(count);

    }

    public static void bfs(int start) {
    	Queue<Integer> q = new LinkedList<Integer>();
    	if (isVisit[start])
    		return;
    	q.add(start);
    	isVisit[start] = true;

    	while (!q.isEmpty()) {
    		int x = q.poll();

    		for (int y : a[x]) {
    			if (!isVisit[y]) {
    				isVisit[y] = true;
    				q.add(y);
    			}
    		}
    	}
    }

    public static void dfs(int x) {
    	if(isVisit[x]) return;
    	isVisit[x] = true;
    	for(int y : a[x]) {
    		dfs(y);
    	}
    }

}