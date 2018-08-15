package algsPractice.oj.UVa.aoapc.bac2nd.ch4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa213 {
  // codes[len][value]
  char[][] code;
  InputReader in;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.in = in;
    while (readcodes()) {
      for (; ; ) {
        int len = readbits(3);
        // out.println("length " + len);
        if (len == 0) {
          in.read();
          break;
        }
        for (; ; ) {
          int v = readbits(len);
          // out.println("value " + v);
          if (v == (1 << len) - 1) break;
          out.print(code[len][v]);
        }
      }
      out.println();
    }
  }

  char readchar() {
    for (; ; ) {
      char c = (char) in.read();
      if (c != '\n' && c != '\r') return c;
    }
  }

  private int readbits(int len) {
    int v = 0;
    while (len-- != 0) {
      v = v * 2 + readchar() - '0';
    }
    return v;
  }

  private boolean readcodes() {
    code = new char[8][1 << 7];
    String t = in.readLine();
    if (t == null) return false;
    char[] s = t.toCharArray();
    int index = 0;
    // code[1][0] = readchar(); // 直接调到下一行开始读取。如果输入已经结束，会读到EOF
    for (int len = 1; len <= 7; len++) {
      for (int i = 0; i < (1 << len) - 1; i++) {
        code[len][i] = s[index++];
        if (index >= s.length) return true;
      }
    }
    return true;
  }
}
