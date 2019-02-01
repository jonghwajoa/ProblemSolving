package boj;

import java.io.*;
import java.util.*;

public class Main {
	final static int INF = Integer.MAX_VALUE;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		int[] input = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		SegmentTree s = new SegmentTree(n, input);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m + k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long c = sc.nextInt();

			if (a == 1) {
				s.update(b - 1, c, 1, 0, n - 1);
			} else {
				sb.append(s.recursiveSum(b - 1, (int) c - 1, 0, n - 1, 1) + "\n");
			}
		}
		System.out.println(sb);

	}
}

class SegmentTree {
	int size;
	long[] segmentTree;

	public SegmentTree(int n, int[] input) {
		int h = ((int) Math.ceil(getDepth(n))) + 1;
		this.size = (int) Math.pow(2, h);
		// Tree의 높이를 구하기위해서 ln(N)+1을 함
		segmentTree = new long[this.size];

		makeSagmentTree(input, 0, n - 1, 1);
	}

	public void makeSagmentTree(int[] input, int l, int r, int curIdx) {
		if (l == r) {
			segmentTree[curIdx] = input[l];
			return;
		}

		int mid = (l + r) / 2;
		int leftChild = curIdx * 2;
		int rightChild = curIdx * 2 + 1;
		makeSagmentTree(input, l, mid, leftChild);
		makeSagmentTree(input, mid + 1, r, rightChild);
		segmentTree[curIdx] = segmentTree[leftChild] + segmentTree[rightChild];

	}

	public void sementTreePrint() {
		System.out.println(Arrays.toString(segmentTree));
	}

	// ln 만드는방법.... log10(n) / log10(2)
	public double getDepth(double n) {
		return Math.log10(n) / Math.log10(2);
	}

	public long recursiveSum(int findLeft, int findRight, int chargeLeft, int chargeRight, int curIdx) {
		if (findLeft > chargeRight || findRight < chargeLeft) {
			return 0;
		}

		if (findLeft <= chargeLeft && chargeRight <= findRight) {
			return segmentTree[curIdx];
		}

		int mid = (chargeLeft + chargeRight) / 2;
		int leftIdx = curIdx * 2;
		int rightIdx = curIdx * 2 + 1;

		return recursiveSum(findLeft, findRight, mid + 1, chargeRight, rightIdx)
				+ recursiveSum(findLeft, findRight, chargeLeft, mid, leftIdx);

	}

	public long update(int idx, long c, int cur, int left, int right) {
		if (idx < left || idx > right)
			return segmentTree[cur];

		if (left == right)
			return segmentTree[cur] = c;

		int mid = (left + right) / 2;
		return segmentTree[cur] = update(idx, c, cur * 2, left, mid) + update(idx, c, cur * 2 + 1, mid + 1, right);
	}

}