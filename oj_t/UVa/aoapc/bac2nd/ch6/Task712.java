package algsPractice.oj_t.UVa.aoapc.bac2nd.ch6;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task712 {
  int[] od;
  int[] vl;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int kase = 0;
    int n;
    while ((n = in.nextInt()) != 0) {
      od = new int[n + 1];
      vl = new int[n + 1];
      for (int i = 0; i < n; i++) {
        od[i] = Integer.parseInt(in.nextString().substring(1)) - 1;
      }
      char[] nodes = in.readLine().toCharArray();
      int m = in.nextInt();
      StringBuilder res = new StringBuilder();
      while (m-- > 0) {
        char[] query = in.readLine().toCharArray();
        int index = 1;
        for (int i = 0; i < n; i++) {
          vl[i] = query[i] - 48;
        }
        for (int i = 0; i < n; i++) {
          if (vl[od[i]] == 0) {
            index *= 2;
          }
          else {
            index = index * 2 + 1;
          }
        }
        index -= 1 << (n - 1) + 1;
        res.append(nodes[index]);
      }
      out.writeln("S-Tree #", ++kase, ":");
      out.writeln(res.toString());
      out.writeln();
    }
  }
}
