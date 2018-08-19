package algsPractice.oj.UVa.aoapc.bac2nd.ch4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.LinkedList;

/**
 * @author Scruel Tao
 */
public class UVa512 {
  LinkedList<String> cmd;
  int BIGINT = 50 * 50 + 10;

  public String simulate(int x, int y) {
    for (String comm : cmd) {
      int dx = 0;
      int dy = 0;
      String[] ss = comm.split(" ");
      if (ss[0].equals("DR")) {
        int op = Integer.parseInt(ss[1]);
        for (int i = 2; i < op + 2; i++) {
          int a = Integer.parseInt(ss[i]);
          if (a == x) {
            return "GONE";
          }
          if (a < x) {
            dx--;
          }
        }
      }
      else if (ss[0].equals("DC")) {
        int op = Integer.parseInt(ss[1]);
        for (int i = 2; i < op + 2; i++) {
          int a = Integer.parseInt(ss[i]);
          if (a == y) {
            return "GONE";
          }
          if (a < y) {
            dy--;
          }
        }
      }
      else if (ss[0].equals("IR")) {
        int op = Integer.parseInt(ss[1]);
        for (int i = 2; i < op + 2; i++) {
          int a = Integer.parseInt(ss[i]);
          if (a <= x) {
            dx++;
          }
        }
      }
      else if (ss[0].equals("IC")) {
        int op = Integer.parseInt(ss[1]);
        for (int i = 2; i < op + 2; i++) {
          int a = Integer.parseInt(ss[i]);
          if (a <= y) {
            dy++;
          }
        }
      }
      else if (ss[0].equals("EX")) {
        int ex = Integer.parseInt(ss[1]);
        int ey = Integer.parseInt(ss[2]);
        int tx = Integer.parseInt(ss[3]);
        int ty = Integer.parseInt(ss[4]);
        if (ex == x && ey == y) {
          x = tx;
          y = ty;
        }
        else if (tx == x && ty == y) {
          x = ex;
          y = ey;
        }
      }
      x += dx;
      y += dy;
    }
    return "moved to (" + x + "," + y + ")";
  }


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int kase = 0;
    while (in.nextInt() != 0) {
      if (kase > 0) {
        out.println();
      }
      cmd = new LinkedList<String>();
      in.nextInt();
      out.println("Spreadsheet #" + ++kase);
      int ct = in.nextInt();
      while (ct-- > 0) {
        cmd.add(in.readLine());
      }
      int qt = in.nextInt();
      while (qt-- > 0) {
        int x = in.nextInt();
        int y = in.nextInt();
        String res = simulate(x, y);
        out.println("Cell data in (" + x + "," + y + ") " + res);
      }
    }
  }
}
