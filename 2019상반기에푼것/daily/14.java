public class Main {

	public static void main(String[] args) {

		String[] input1 = { "apple", "apps", "ape" };
		String[] input2 = { "hawaii", "happy" };
		String[] input3 = { "dog", "dogs", "doge" };

		solve(input1);
		solve(input2);
		solve(input3);
	}

	public static void solve(String[] input) {

		String prefix = input[0];

		for (int i = 1; i < input.length; i++) {
			int prefixLen = prefix.length();
			int nextLen = input[i].length();
			int commonLen = 0;
			if (nextLen < prefixLen) {
				prefixLen = nextLen;
			}

			for (int j = 0; j < prefixLen; j++) {
				if (prefix.charAt(j) == input[i].charAt(j)) {
					commonLen += 1;
				} else {
					break;
				}
			}
			prefix = prefix.substring(0, commonLen);
		}
		System.out.println(prefix.length());
	}
}
