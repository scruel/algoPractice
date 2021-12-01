package algsPractice.oj.luogu.trial.L2.L2_4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;

/**
 * @author Scruel Tao
 */
public class P1583 {
  class Person implements Comparable<Person> {
    int no, v;

    public Person(int no, int v) {
      this.no = no;
      this.v = v;
    }

    @Override
    public int compareTo(Person o) {
      if (o.v == v) return no - o.no;
      return o.v - v;
    }
  }

  int[] e = new int[10 + 5];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    for (int i = 0; i < 10; i++) {
      e[i] = in.nextInt();
    }
    Person[] ps = new Person[n];
    for (int i = 0; i < n; i++) {
      ps[i] = new Person(i + 1, in.nextInt());
    }

    Arrays.sort(ps);

    for (int i = 0; i < n; i++) {
      ps[i].v += e[i % 10];
    }

    Arrays.sort(ps);

    for (int i = 0; i < k; i++) {
      if (i != 0) out.print(" ");
      out.print(ps[i].no);
    }
  }
}
