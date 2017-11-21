package algsPractice.competition.JSK2017.round3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

public class TaskA {
  int L, t, T;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    L = in.nextInt();
    t = in.nextInt();
    T = in.nextInt();

    int A = T;
    int B = T - t;
    int tmpA = A % L;
    if (((A / L) & 1) == 0) {
      A = tmpA;
    }
    else {
      A = L - tmpA;
    }
    int tmpB = B % L;
    if (((B / L) & 1) == 0) {
      B = L - tmpB;
    }
    else {
      B = tmpB;
    }
    out.write(Math.abs(A - B));
  }
}
