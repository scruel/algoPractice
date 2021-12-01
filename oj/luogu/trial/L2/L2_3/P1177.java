package algsPractice.oj.luogu.trial.L2.L2_3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Random;

/**
 * @author Scruel Tao
 */
public class P1177 {
  int n;
  int[] a = new int[100000 + 5];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    sort(0, n - 1);

    for (int i = 0; i < n; i++) {
      if (i != 0) out.print(' ');
      out.print(a[i]);
    }
    out.println();
  }

  public void sort(int lo, int hi) {
    if (lo >= hi) return;
    int k = partition(lo, hi);
    sort(lo, k - 1);
    sort(k + 1, hi);
  }

  // TODO 三项切分
  private int partition(int lo, int hi) {
    swap(lo, lo + new Random().nextInt(hi - lo + 1));
    int k = a[lo];
    int i = lo + 1;
    int j = hi;
    for (; ; ) {
      while (i <= hi && a[i] < k) i++;
      while (j >= 0 && a[j] > k) j--;
      if (i > j) break;
      swap(i, j);
      i++;
      j--;
    }
    swap(lo, i - 1);
    return i - 1;
  }

  public void swap(int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}
