package algsPractice.competition.nod51.lagou2017;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #simulate
 */
public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] hs = new int[n];
    int[] ps = new int[m];

    for (int i = 0; i < n; i++)
      hs[i] = in.nextInt();
    for (int i = 0; i < m; i++)
      ps[i] = in.nextInt();
    int i, j, h;
    i = j = h = 0;
    while (i < m && j < n && j >= 0) {
      for (j = 0; j < n && ps[i] <= hs[j]; j++) {
      }
      j--;
      if (j < 0) {
        break;
      }
      if (ps[i] <= hs[j]) {
        i++;
      }
      hs[j] = 0;
      j--;
    }
    out.writeln(i);
  }
}
