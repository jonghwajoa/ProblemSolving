import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] isVisit;
	static boolean[][] vertex;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer input = new StringTokenizer(br.readLine());

		N = Integer.parseInt(input.nextToken());
		int repeat = Integer.parseInt(input.nextToken());
		int start = Integer.parseInt(input.nextToken());

		vertex = new boolean[N + 1][N + 1];
		isVisit = new boolean[N + 1];
		while (repeat-- > 0) {
			int[] edge = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
			vertex[edge[0]][edge[1]] = true;
			vertex[edge[1]][edge[0]] = true;
		}

		dfs(start);
		System.out.println();
		Arrays.fill(isVisit, false);
		bfs(start);

	}

	public static void dfs(int start) {
		if (isVisit[start])
			return;
		isVisit[start] = true;
		System.out.print(start + " ");
		for (int i = 1; i <= N; i++) {
			if (vertex[start][i] && !isVisit[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		isVisit[node] = true;
		while (!q.isEmpty()) {
			int point = q.poll();
			System.out.print(point + " ");
			for (int i = 1; i <= N; i++) {
				if (vertex[point][i] && !isVisit[i]) {
					isVisit[i] = true;
					q.add(i);
				}
			}
		}
		System.out.println();
	}
}



/* ##################################### */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean[] isVisit;
	static ArrayList<Integer>[] a;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		isVisit = new boolean[n + 1];
		a = (ArrayList<Integer>[]) new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}

		dfs(start);
		System.out.println();
		Arrays.fill(isVisit, false);
		bfs(start);
		System.out.println();

	}

	public static void dfs(int x) {
		if (isVisit[x])
			return;
		isVisit[x] = true;
		System.out.print(x + " ");
		for (int y : a[x]) {
			if (!isVisit[y])
				dfs(y);
		}
	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		isVisit[start] = true;
		while (!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x + " ");
			for (int y : a[x]) {
				if (!isVisit[y]) {
					isVisit[y] = true;
					q.add(y);
				}
			}
		}
	}
}