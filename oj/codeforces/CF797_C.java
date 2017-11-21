package algsPractice.oj.codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Scruel on 2017/5/4.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com3/scruel
 * #greedy
 */
public class CF797_C {
  static void solve() throws IOException {
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
    String s;
    while ((s = bfr.readLine()) != null && !s.isEmpty()) {
      int sIndex = 0;
      StringBuilder t = new StringBuilder("");
      StringBuilder n = new StringBuilder("");
      for (int i = 0; i < 26; i++) {
        char c = (char) ('a' + i);
        int sTmpIndex;
        while ((sTmpIndex = s.indexOf(c, sIndex)) != -1) {
          //倒出s，倒入t
          t.append(s.substring(sIndex, sTmpIndex));
          //贪心选取最小的s中的字符为n的一部分
          n.append(c);
          if (sIndex > s.length() - 1) {
            break;
          }
          sIndex = sTmpIndex + 1;
        }
        if (sIndex > s.length() - 1) {
          break;
        }
        int tIndex = t.length() - 1;
        while (tIndex >= 0 && t.charAt(tIndex) <= (char) (c + 1))
          tIndex--;
        //倒出t

        n.append(new StringBuilder(t.substring(tIndex + 1, t.length())).reverse());
        t = new StringBuilder(t.substring(0, tIndex + 1));
      }
      n.append(t.reverse());
      bfw.write(n.toString());
      bfw.flush();
    }
    bfw.close();
    bfr.close();
  }


  public static void main(String[] args) throws IOException {
    solve();
  }
}
