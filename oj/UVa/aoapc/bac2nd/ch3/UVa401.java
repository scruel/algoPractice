package algsPractice.oj.UVa.aoapc.bac2nd.ch3;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa401 {
  String[] res = {"not a palindrome.", "a regular palindrome.", "a mirrored string.", "a mirrored palindrome."};
  String reverse = "A   3  HIL JM O   2TUVWXY51SE Z  8 ";

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s;
    while ((s = in.readLine()) != null && !s.isEmpty()) {
      int p = 1;
      int m = 2;
      int n = s.length();
      for (int i = 0; i <= n / 2; i++) {
        if (s.charAt(i) != r(s.charAt(n - 1 - i))) {
          m = 0;
        }
        if (s.charAt(i) != s.charAt(n - 1 - i)) {
          p = 0;
        }
      }
      out.printf("%s -- is %s\n\n", s, res[m + p]);
    }
  }

  private char r(char c) {
    if (Character.isDigit(c)) {
      return reverse.charAt(c - '0' + 25);
    }
    else {
      return reverse.charAt(c - 'A');
    }
  }

}
