package algsPractice.oj.luogu.trial.L2.L2_3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;

/**
 * @author Scruel Tao
 */
public class P1068 {
  class Person implements Comparable<Person> {
    int no, v;

    public Person(int no, int v) {
      this.no = no;
      this.v = v;
    }

    @Override
    public int compareTo(Person o) {
      // 从大到小排序
      if (o.v == v) return no - o.no;
      return o.v - v;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = (int) (in.nextInt() * 1.5) - 1;
    Person[] ps = new Person[n];
    for (int i = 0; i < n; i++) {
      int no = in.nextInt();
      int v = in.nextInt();
      Person p = new Person(no, v);
      ps[i] = p;
    }
    Arrays.sort(ps);
    int v = ps[m].v;
    int i = 0;
    StringBuilder res = new StringBuilder();
    for (; i < n; i++) {
      Person p = ps[i];
      if (p.v < v) break;
      res.append(String.format("%d %d\n", p.no, p.v));
    }
    out.printf("%d %d\n", v, i);
    out.print(res);
  }
}
