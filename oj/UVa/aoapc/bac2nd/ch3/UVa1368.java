package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa1368 {
  private String seq = "ACGT"; // 由于判断的字符为有限个, 可以去掉 256 次循环, 直接定位大小

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.nextInt();
    while (t-- != 0) {
      int n = in.nextInt();
      int m = in.nextInt();
      int[][] a = new int[m][256];
      while (n-- != 0) {
        String s = in.readLine();
        for (int i = 0; i < m; i++) {
          a[i][s.charAt(i)]++;
        }
      }
      StringBuilder ress = new StringBuilder();
      int res = 0;
      for (int i = 0; i < m; i++) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int sum = 0;
        for (int j = 0; j < 256; j++) {
          sum += a[i][j];
          if (a[i][j] > max) {
            maxIndex = j;
            max = a[i][j];
          }
        }
        res += sum - max;
        ress.append((char) maxIndex);
      }
      out.printf("%s\n%d\n", ress, res);
    }
  }
}
