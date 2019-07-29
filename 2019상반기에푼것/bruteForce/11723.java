import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int bitSet = 0;
		while (N-- > 0) {
			String[] line = br.readLine().split("\\s");
			if (line[0].equals("all") || line[0].equals("empty")) {
				if (line[0].equals("all")) {
					bitSet = (1 << 21) - 1;
				} else if (line[0].equals("empty")) {
					bitSet = 0;
				}
			} else {
				int val = Integer.parseInt(line[1]);
				if (line[0].equals("add")) {
					bitSet |= (1 << val);
				} else if (line[0].equals("remove")) {
					bitSet &= ~(1 << val);
				} else if (line[0].equals("check")) {
					int res = bitSet & (1 << val);
					if (res >= 1) {
						sb.append(1 + "\n");
					} else {
						sb.append(0 + "\n");
					}
				} else if (line[0].equals("toggle")) {
					bitSet ^= (1 << val);
				}
			}
		}
		System.out.print(sb);
	}
}