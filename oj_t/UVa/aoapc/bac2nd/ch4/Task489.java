package algsPractice.oj_t.UVa.aoapc.bac2nd.ch4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Scruel on 2017/4/5.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #simulate
 */
public class Task489 {
  static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    while (true) {
      String rT = bfr.readLine();
      int roundNum = Integer.parseInt(rT);
      if (roundNum == -1) {
        break;
      }

      String cS = bfr.readLine();
      String pS = bfr.readLine();
      int[] displayed = new int[256];
      for (int i = 0; i < cS.length(); i++) {
        displayed[cS.charAt(i)]++;
      }
      int cRNum = 0;
      for (int i = 0; i < 256; i++) {
        if (displayed[i] > 0) {
          cRNum++;
        }
      }
      int pRNum = 0;
      int pFNum = 0;
      for (int i = 0; i < pS.length(); i++) {
        if (pFNum > 6) {
          break;
        }
        if (pRNum == cRNum) {
          break;
        }
        char ch = pS.charAt(i);
        if (displayed[ch] == 0) {
          pFNum++;
        }
        else if (displayed[ch] > 0) {
          displayed[ch] = -1;
          pRNum++;
        }
      }
      bfw.write("Round " + roundNum + "\n");
      if (pFNum > 6) {
        bfw.write("You lose.\n");
      }
      else if (pRNum == cRNum) {
        bfw.write("You win.\n");
      }
      else {
        bfw.write("You chickened out.\n");
      }
    }
    bfr.close();
    bfw.close();

  }
}
