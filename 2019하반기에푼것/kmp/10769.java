import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.print.attribute.standard.Sides;

public class Main {
  final static String SMILE = ":-)";
  final static String SAD = ":-(";

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String string = br.readLine();

    int smile = kmp(string, SMILE);
    int sad = kmp(string, SAD);

    String ans = "";
    if (sad == 0 && smile == 0) {
      ans = "none";
    } else if (sad == smile) {
      ans = "unsure";
    } else if (sad < smile) {
      ans = "happy";
    } else {
      ans = "sad";
    }
    System.out.println(ans);
  }

  private static int kmp(String origin, String pattern) {
    int[] pi = getPi(pattern);
    int patternLength = pattern.length();
    int originLength = origin.length();
    char[] originChars = origin.toCharArray();
    char[] patternChars = pattern.toCharArray();

    int j = 0;
    int count = 0;
    for (int i = 0; i < originLength; i++) {
      while (0 < j && originChars[i] != patternChars[j]) {
        j = pi[j - 1];
      }

      if (originChars[i] == patternChars[j]) {
        if (j == patternLength - 1) {
          count += 1;
        } else {
          j += 1;
        }
      }
    }

    return count;
  }

  private static int[] getPi(String pattern) {
    int length = pattern.length();
    int[] pi = new int[length];
    char[] chars = pattern.toCharArray();

    int j = 0;
    for (int i = 1; i < length; i++) {
      while (0 < j && chars[i] != chars[j]) {
        j = pi[j - 1];
      }

      if (chars[i] == chars[j]) {
        j += 1;
        pi[i] = j;
      }
    }
    return pi;
  }
}
