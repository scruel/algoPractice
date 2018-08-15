package algsPractice.oj.UVa.aoapc.bac2nd.ch4;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class UVa489 {
  public void solvex(int testNumber, InputReader in, OutputWriter out) {
    while (true) {
      int k = in.nextInt();
      if (k == -1) break;
      out.print("Round " + k + "\n");

      String a = in.readLine();
      String b = in.readLine();
      int[] displayed = new int[256];
      for (int i = 0; i < a.length(); i++) {
        displayed[a.charAt(i)]++;
      }
      int cRNum = 0;
      for (int i = 0; i < 256; i++) {
        if (displayed[i] > 0) {
          cRNum++;
        }
      }
      int pRNum = 0;
      int pFNum = 0;
      for (int i = 0; i < b.length(); i++) {
        if (pFNum > 6) {
          break;
        }
        if (pRNum == cRNum) {
          break;
        }
        char ch = b.charAt(i);
        if (displayed[ch] == 0) {
          pFNum++;
        }
        else if (displayed[ch] > 0) {
          displayed[ch] = -1;
          pRNum++;
        }
      }
      if (pFNum > 6) {
        out.print("You lose.\n");
      }
      else if (pRNum == cRNum) {
        out.print("You win.\n");
      }
      else {
        out.print("You chickened out.\n");
      }
    }
  }

  // 规整但慢
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    while (true) {
      int k = in.nextInt();
      if (k == -1) break;
      out.printf("Round %d\n", k);
      String a = in.readLine();
      String b = in.readLine();

      int chance = 7;
      int left = a.length();
      boolean win = false;
      boolean lose = false;
      int[] count = new int[256];
      for (int i = 0; i < a.length(); i++) {
        count[a.charAt(i)]++;
      }
      for (int i = 0; i < b.length(); i++) {
        char x = b.charAt(i);
        if (count[x] == 0) {
          chance--;
        }
        else if (count[x] > 0) {
          left -= count[x];
          count[x] = -1;
        }
        if (chance <= 0) lose = true;
        if (left == 0) win = true;
        if (lose || win) break;
      }
      if (lose) out.println("You lose.");
      else if (win) out.println("You win.");
      else out.println("You chickened out.");
    }
  }
}
