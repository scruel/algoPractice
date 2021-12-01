package algsPractice.oj.luogu.trial.L1.L1_5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class P1055 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String isbn = in.readLine();
    char q = isbn.charAt(isbn.length() - 1);
    isbn = isbn.substring(0, isbn.length() - 1);
    int v = 0;
    int cnt = 1;

    for (int i = 0; i < isbn.length(); i++) {
      char c = isbn.charAt(i);
      if (Character.isDigit(c)) {
        v += ((c - '0') * cnt) % 11;
        cnt++;
      }
    }
    v %= 11;
    char c = (char) ('0' + v);
    if (c == '0' + 10) c = 'X';
    if (c == q) out.println("Right");
    else out.println(isbn + c);
  }
}
