package algsPractice.competition.codem.a;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 */
public class TaskC {
  static final double EPS = 1e-10;
  int n;
  int T, C;
  int MAXN = 100000 + 10;
  int[] tnums = new int[MAXN];
  int[] cnums = new int[MAXN];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    T = in.nextInt();
    C = in.nextInt();
    int maxT = 0;
    for (int i = 0; i < n; i++) {
      tnums[i] = in.nextInt();
      cnums[i] = in.nextInt();
      maxT = Math.max(maxT, tnums[i]);
    }
    if (T > maxT) {
      double at = 0;
      double ac = 0;
      for (int i = 0; i < n; i++) {
        int t1 = tnums[i];
        int c1 = cnums[i];
        at = (t1 * c1 + at * ac) / (c1 + ac);
        ac += c1;
      }
      at = (T * C + at * ac) / (C + ac);
      if (at < maxT) {
        out.writeln("Impossible");
      }
      else {
        out.writeln(String.format("%.4f", at));
      }
    }
    else {

      double at = 0;
      double ac = 0;
      for (int i = 0; i < n; i++) {
        int t1 = tnums[i];
        int c1 = cnums[i];
        at = (t1 * c1 + at * ac) / (c1 + ac);
        ac += c1;
      }
      //
      //            for (int i = 0 ;i < )
      at = (T * C + at * ac) / (C + ac);
      if (at < maxT) {
        out.writeln("Impossible");
      }
      else {
        out.writeln(String.format("%.4f", at));
      }
    }
  }
}