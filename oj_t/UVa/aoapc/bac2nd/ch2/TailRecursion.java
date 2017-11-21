package algsPractice.oj_t.UVa.aoapc.bac2nd.ch2;

/**
 * Created by Scruel on 2017/11/19 019.
 * Github : https://github.com/scruel
 */
public class TailRecursion {
  public static void main(String[] args) {
    System.out.println(solve(4, 0));
  }

  private static int solve(int i, int j) {
    if (i <= 1) return i + j;
    return solve(i - 1, i + j);
  }
}
