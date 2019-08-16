import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] argv) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] word = br.readLine().toCharArray();

        int strLen = str.length;
        char[] stack = new char[strLen];

        int wordLen = word.length;
        int stackIdx = 0;

        S: for (int i = 0; i < strLen; i++) {
            stack[stackIdx++] = str[i];
            if (wordLen <= stackIdx) {
                int standard = stackIdx - wordLen;
                for (int j = 0; j < wordLen; j++) {
                    if (stack[standard + j] != word[j]) {
                        standard += 1;
                        continue S;
                    }
                }
                stackIdx -= wordLen;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stackIdx; i++) {
            sb.append(stack[i]);
        }
        System.out.println(sb.toString().length() == 0 ? "FRULA" : sb);
    }
}