package algsPractice.oj.luogu.L1_5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1598 {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s;
    int max = 0;
    int[] cnt = new int[26];
    while ((s = in.readLine()) != null) {
      for (int i = 0; i < s.length(); i++) {
        if (!Character.isAlphabetic(s.charAt(i))) continue;
        int v = s.charAt(i) - 'A';
        cnt[v]++;
        if (cnt[v] > max) max = cnt[v];
      }
    }

    for (int i = max; i > 0; i--) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < 26; j++) {
        if (j != 0) sb.append(' ');
        if (cnt[j] >= i) {
          out.print(sb);
          sb.setLength(0);
          out.print('*');
        }
        else sb.append(' ');
      }
      out.print('\n');
    }
    for (int i = 0; i < 26; i++) {
      if (i != 0) out.print(' ');
      out.print((char)('A' + i));
    }
    out.print('\n');
  }
}
