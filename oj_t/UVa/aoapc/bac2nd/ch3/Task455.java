package algsPractice.oj_t.UVa.aoapc.bac2nd.ch3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Created by Scruel on 2017/4/3.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #string
 */
public class Task455 {
  static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
  static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

  static boolean ok(String s, int t) {
    int up = s.length() - t;
    for (int i = 0; i < up; i++) {
      if (s.charAt(i) != s.charAt(i + t)) {
        return false;
      }
    }
    return true;
  }

  static void solve() throws IOException {
    int n = Integer.parseInt(bfr.readLine().trim());
    //读入为空的时候继续读入
    for (int t = 0; t < n; t++) {
      String s = bfr.readLine();
      while (s.length() == 0)
        s = bfr.readLine();
      s = s.trim();
      boolean flag = true;
      int len = s.length();
      int up = len / 2 + 1;
      for (int i = 1; i < up; i++) {
        //cacacac的情况
        if (len % i != 0) {
          continue;
        }
        if (ok(s, i)) {
          bfw.write(i + "");
          flag = false;
          break;
        }
      }
      if (flag) {
        bfw.write(s.length() + "");
      }
      //本题需要注意输出格式。。。
      if (t != n - 1) {
        bfw.write("\n\n");
      }
      else {
        bfw.write("\n");
      }
    }
    bfr.close();
    bfw.close();
  }


  static void solve2() {
    Scanner scn = new Scanner(System.in);
    int n = Integer.parseInt(scn.nextLine()), i = 0;
    for (int num = 0; num < n; num++) {
      String str;
      while (true) {
        str = scn.nextLine();
        if (!str.equals("")) {
          break;
        }
      }
      StringBuilder sub = new StringBuilder();
      for (i = 0; i < str.length(); i++) {
        sub.append(str.charAt(i));
        if (str.length() % sub.length() != 0) {
          continue;
        }
        boolean b = true;
        for (int j = 0; j < str.length(); j += sub.length()) {
          if (!str.substring(j, j + sub.length()).equals(sub.toString())) {
            b = false;
            break;
          }
        }
        if (b) {
          break;
        }
      }
      if (num != 0) {
        System.out.println();
      }
      System.out.println(i + 1);
    }
  }

  public static void main(String[] args) throws IOException {
    //                System.out.println(1<<20);
    solve();

  }

}
