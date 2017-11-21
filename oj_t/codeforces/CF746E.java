package algsPractice.oj_t.codeforces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Scruel on 2017/5/10.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #structure
 * //REDO
 */
public class CF746E {
  static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
  static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
  static HashSet<Integer> M1 = new HashSet<Integer>();
  static HashSet<Integer> M2 = new HashSet<Integer>();
  static HashSet<Integer> V = new HashSet<Integer>();
  static String[] rts;
  static int[] arr;
  static boolean[] isRep;
  static int n, m;


  public static void main(String[] args) throws IOException {
    rts = bfr.readLine().split("\\s+");
    n = Integer.parseInt(rts[0]);
    m = Integer.parseInt(rts[1]);
    arr = new int[n + 1];
    isRep = new boolean[n];
    rts = bfr.readLine().split("\\s+");

    for (int i = 1; i <= n; i++) {
      int tmp = Integer.parseInt(rts[i - 1]);
      arr[i] = tmp;
      if ((arr[i] & 1) == 1) {
        M1.add(arr[i]);
      }
      else {
        M2.add(arr[i]);
      }
    }


    for (int i = 1; i <= Math.min(2 * n, m); i++) {
      if ((i & 1) == 1) {
        if (!M1.contains(i)) {
          V.add(i);
          M1.remove(i);
        }
      }
      else {
        if (!M2.contains(i)) {
          V.add(i);
          M2.remove(i);
        }
      }
    }
    int od, ev;
    if ((m & 1) == 1) {
      od = m / 2 + 1;
    }
    else {
      od = m / 2;
    }
    ev = m / 2;
    for (int i : M1)
      if (i > m) {
        od++;
      }
    for (int i : M2)
      if (i > m) {
        ev++;
      }

    if (2 * Math.min(od, ev) < n) {
      bfw.write("-1");
    }
    else {
      int cnt = 0;
      if (M1.size() > n / 2) {
        cnt = M1.size() - n / 2;
      }
      for (Iterator<Integer> iter = M1.iterator(); iter.hasNext(); ) {
        int tmp = iter.next();
        if (cnt == 0) {
          break;
        }
        cnt--;
        V.add(tmp);
        iter.remove();
      }
      cnt = 0;
      if (M2.size() > n / 2) {
        cnt = M2.size() - n / 2;
      }
      for (Iterator<Integer> iter = M2.iterator(); iter.hasNext(); ) {
        int tmp = iter.next();
        if (cnt == 0) {
          break;
        }
        cnt--;
        V.add(tmp);
        iter.remove();
      }
      int x = 1, y = 2;
      int ans = 0;
      int qx, qy;
      qx = M1.size();
      qy = M2.size();
      for (int i = 1; i <= n; i++) {
        if ((arr[i] & 1) == 1) {
          if (M1.contains(arr[i])) {
            M1.remove(arr[i]);
          }
          else {
            if (qx <= qy) {
              while (!V.contains(x))
                x += 2;
              arr[i] = x;
              ans++;
              qx++;
              V.remove(x);
            }
            else {
              while (!V.contains(y))
                y += 2;
              arr[i] = y;
              ans++;
              qy++;
              V.remove(y);
            }
          }
        }
        else {
          if (M2.contains(arr[i])) {
            M2.remove(arr[i]);
          }
          else {
            if (qx <= qy) {
              while (!V.contains(x))
                x += 2;
              arr[i] = x;
              ans++;
              qx++;
              V.remove(x);
            }
            else {
              while (!V.contains(y))
                y += 2;
              arr[i] = y;
              ans++;
              qy++;
              V.remove(y);
            }
          }
        }
      }
      bfw.write(ans + "\n");
      for (int i = 1; i <= n; i++)
        bfw.write(String.format("%d%c", arr[i], i == n ? '\n' : ' '));
    }


    bfw.close();
    bfr.close();
  }
}
