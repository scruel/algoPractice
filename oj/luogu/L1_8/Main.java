package algsPractice.oj.luogu.L1_8;

/**
 * @author Scruel Tao
 * @version 1.0
 */

import java.io.*;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author scruel
 */
public class Main {
  public static void main(String[] args) throws IOException {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream));
    int n = Integer.parseInt(in.readLine());
    boolean f = false;
    int b = 2;
    int v = 1;
    int x = 2;
    while (v < n) {
      v += b++;
      f = !f;
      x++;
    }
    int n1 = v - n + 1;
    int n2 = x - n1;
    if (f) out.write(String.format("%d/%d\n", n2, n1));
    else out.write(String.format("%d/%d\n", n1, n2));
    out.close();
  }
}

