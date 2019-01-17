
import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String test = br.readLine();

		System.out.println(reverse(test));
		reverse2(test);

	}

	public static String reverse(String src) {
		char[] ch = src.toCharArray();
		for (int i = 0; i < ch.length / 2; i++) {
			char tmp = ch[i];
			ch[i] = ch[ch.length - 1 - i];
			ch[ch.length - 1 - i] = tmp;
		}
		return new String(ch);
	}

	public static void reverse2(String src) {
		StringBuilder sb = new StringBuilder(src);
		int len = src.length();
		for (int i = 0; i < len / 2; i++) {
			char tmp = sb.charAt(i);
			sb.setCharAt(i, src.charAt(len - 1 - i));
			sb.setCharAt(len - 1 - i, tmp);
		}
		System.out.println(sb);
	}
}