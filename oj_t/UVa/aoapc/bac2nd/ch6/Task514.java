package algsPractice.oj_t.UVa.aoapc.bac2nd.ch6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Scruel on 2017/5/16.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #simulate
 */
public class Task514 {
  static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int[] qList = new int[1005];
  static Stack<Integer> stack = new Stack<Integer>();

  public static void main(String[] args) throws IOException {
    String s;
    MyScanner sc = new MyScanner();
    int n;
    while ((n = sc.nextInt()) != 0) {
      while (true) {
        if ("0".equals(sc.nextLine())) {
          sc.nextInt();
          bfw.write("\n");
          break;
        }
        for (int i = 1; i <= n; i++) {
          qList[i] = sc.nextInt();
        }
        int A = 1;
        int B = 1;
        boolean ok = true;
        while (B <= n) {
          if (A == qList[B]) {
            A++;
            B++;
          }
          else if (!stack.isEmpty() && stack.peek() == qList[B]) {
            stack.pop();
            B++;
          }
          else if (A <= n) {
            stack.push(A++);
          }
          else {
            ok = false;
            break;
          }
        }
        bfw.write(String.format("%s\n", ok ? "Yes" : "No"));
      }
    }
    sc.bfr.close();
    bfw.close();
  }

  static class MyScanner {
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String next() throws IOException {
      while (st == null || !st.hasMoreElements()) {
        st = new StringTokenizer(bfr.readLine());
      }
      return st.nextToken();
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    String nextLine() throws IOException {
      String s = bfr.readLine();
      st = new StringTokenizer(s);
      return s;
    }
  }
}
