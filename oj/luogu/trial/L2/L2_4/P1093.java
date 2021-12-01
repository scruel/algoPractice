package algsPractice.oj.luogu.trial.L2.L2_4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;

/**
 * @author Scruel Tao
 */
public class P1093 {
  class Stu implements Comparable<Stu> {
    int no, a, b, c, v;

    public Stu(int no, int a, int b, int c) {
      this.no = no;
      this.a = a;
      this.b = b;
      this.c = c;
      this.v = a + b + c;
    }

    @Override
    public int compareTo(Stu o) {
      if (o.v == v) {
        if (o.a == a) return no - o.no;
        return o.a - a;
      }
      return o.v - v;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Stu[] stus = new Stu[n];

    for (int i = 0; i < n; i++) {
      stus[i] = new Stu(i + 1, in.nextInt(), in.nextInt(), in.nextInt());
    }

    Arrays.sort(stus);

    for (int i = 0; i < 5; i++) {
      out.printf("%d %d\n", stus[i].no, stus[i].v);
    }
  }
}
