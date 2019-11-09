import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String origin = br.readLine();
    String pattern = br.readLine();

    System.out.println(kmp(origin, pattern) ? 1 : 0);
  }

  private static boolean kmp(String origin, String pattern) {
    int[] pi = getPi(pattern);
    int patternLength = pattern.length();
    int originLength = origin.length();
    char[] originChars = origin.toCharArray();
    char[] patternChars = pattern.toCharArray();

    int j = 0;
    for (int i = 0; i < originLength; i++) {
      while (0 < j && originChars[i] != patternChars[j]) {
        j = pi[j - 1];
      }

      if (originChars[i] == patternChars[j]) {
        if (j == patternLength - 1) {
          return true;
        }
        j += 1;
      }
    }

    return false;
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