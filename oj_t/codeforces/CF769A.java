package algsPractice.oj_t.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Scruel on 2017/4/24.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class CF769A {
  public static void main(String[] args) throws IOException {
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bfr.readLine());
    int[] years = new int[n];
    String[] rts = bfr.readLine().split("\\s+");
    for (int i = 0; i < rts.length; i++) {
      years[i] = Integer.parseInt(rts[i]);
    }
    int year;
    for (int x = 0; x < 100; x++) {
      for (int i = 0; i < n; i++) {
        boolean flag = true;
        year = years[i];
        for (int j = 0; j < n; j++) {
          if (j == i) {
            continue;
          }
          if (Math.abs(years[j] - years[i]) > x) {
            flag = false;
            break;
          }
        }
        if (flag) {
          System.out.println(year);
          return;
        }
      }
    }
  }
}
