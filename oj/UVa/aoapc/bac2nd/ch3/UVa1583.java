package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa1583 {
  int maxn = 100005;
  int[] arr = new int[maxn];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.nextInt();
    for (int i = 1; i < maxn; i++) {
      int y = i + s(i);
      if (y < maxn && arr[y] == 0) {
        arr[y] = i;
      }
    }
    while (t-- != 0) {
      int n = in.nextInt();
      out.println(arr[n]);
    }
  }

  int s(int i) {
    int sum = 0;
    while (i != 0) {
      sum += i % 10;
      i /= 10;
    }
    return sum;
  }
}
