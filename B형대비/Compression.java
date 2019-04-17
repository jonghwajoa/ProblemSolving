import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

	public static void main(String args[]) throws Exception {

		int[][] input = { { -12312, 131231 }, { 123123, 21321321 }, { -12321, -123123123 }, { 12, -213 }, { 55, 123 },
				{ 31213, -1312 }, { 7567, -53453 }, { 345, 5344523 } };

		int[][] point = compression(input);
		System.out.println("-----------------");

		StringBuilder sb = new StringBuilder();
		for (int[] cur : point) {
			sb.append(Arrays.toString(cur) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int[][] compression(int[][] input) {
		HashSet<Integer> setX = new HashSet<>();
		HashSet<Integer> setY = new HashSet<>();

		for (int cur[] : input) {
			setX.add(cur[0]);
			setY.add(cur[1]);
		}

		LinkedList<Integer> listX = new LinkedList<>(setX);
		LinkedList<Integer> listY = new LinkedList<>(setY);

		Collections.sort(listX);
		Collections.sort(listY);
		System.out.println(listX.toString());
		System.out.println(listY.toString());

		int mapLength = input.length;
		int[][] newMap = new int[mapLength][2];
		for (int i = 0; i < mapLength; i += 1) {
			newMap[i][0] = listX.indexOf(input[i][0]);
			newMap[i][1] = listY.indexOf(input[i][1]);
		}
		return newMap;
	}
}
