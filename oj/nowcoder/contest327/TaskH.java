package algsPractice.oj.nowcoder.contest327;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Scruel Tao
 */
public class TaskH {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    solve(out);
    return;
  }

  static int a[] = new int[400000000];
  List<Integer> l = new LinkedList<>();

  private void solve(OutputWriter out) {
    for (int i = 1; i <= 400000000; i++) {
      a[i] = num(i);
      if (i % 10000 == 0) System.out.println(i);
    }
    System.out.println("--------------------------");
    for (int i = 1; i <= 400000000; i++) {
      l = new ArrayList<>();
      l.add(i);
      if (i % 10000 == 0) System.out.println(i);
      for (int j = i + 1; j <= 400000000; j++) {
        if (l.size() >= 2000) {
          System.out.println("--------------------------");
          System.out.println(l.stream().map(Object::toString).collect(Collectors.joining(",")));
          return;
        }
        if (check(j)) {
          l.add(j);
        }
      }
    }
    out.println(l.stream().map(Object::toString).collect(Collectors.joining(",")));
  }

  boolean check(int n) {
    for (Integer t : l) {
      if (gcd(n, t) != 1) return false;
      // if (num(t * n) <= 10) return false;
      if (a[t] * a[n] <= 10) return false;
    }
    return true;
  }

  int gcd(int m, int n) {
    if (n == 0) {
      return m;
    }
    return gcd(n, m % n);
  }

  int num(int n) {
    if (n == 1) return 1;
    double sq = Math.sqrt(n);
    int count = 2;
    for (int i = 2; i <= sq; i++) {
      if (n % i == 0) {
        if (i == sq && n / i == i) {
          count++;
        }
        else count += 2;
      }
    }
    return count;
  }
}
