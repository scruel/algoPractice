package algsPractice.competition.JSK2017.round5;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Scruel.  
 * Github : https://github.com/scruel
 * TODO
 */
public class TaskB {
  //len
  HashMap<Integer, HashMap<String, Integer>> map = null;

  String intToS(int[] arr) {
    int[] a = new int[200000];
    for (int anArr : arr) {
      a[anArr]++;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 200000; i++) {
      sb.append(a[i]);
    }
    return sb.toString();
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = in.nextInt();
    }
    int T = in.nextInt();
    while (T-- > 0) {
      HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
      int m = in.nextInt();
      int[] cks = new int[m];
      for (int i = 0; i < m; i++) {
        cks[i] = in.nextInt();
        if (map.containsKey(cks[i])) {
          map.get(cks[i])[0]++;
        }
        else {
          Integer[] its = new Integer[2];
          its[0] = 1;
          its[1] = 0;
          map.put(cks[i], its);
        }
      }
      int res = 0;
      for (int i = 0; i <= n - m; i++) {
        boolean flag = true;
        for (int j = i; j < m + i; j++) {
          if (!map.containsKey(nums[j])) {
            flag = false;
            break;
          }
          else {
            map.get(nums[j])[1]++;
          }
        }

        for (Map.Entry<Integer, Integer[]> en : map.entrySet()) {
          Integer[] its = en.getValue();
          if (!its[0].equals(its[1])) {
            flag = false;
          }
          its[1] = 0;
        }

        if (flag) {
          res++;
        }
      }
      out.writeln(res);
    }
  }

  //    public void solve(int testNumber, InputReader in, OutputWriter out) {
  //        map = new HashMap<Integer, HashMap<String, Integer>>();
  //        int n = in.nextInt();
  //        int[] nums = new int[n];
  //        for (int i = 0; i < n; i++) {
  //            nums[i] = in.nextInt();
  //        }
  //        for (int i = 0; i < n; i++) {
  //            for (int j = 0; j < n - i; j++) {
  //                int len = i + 1;
  //                int[] tmp = new int[len];
  //                System.arraycopy(nums, j, tmp, 0, len);
  //                String res = intToS(tmp);
  //                if (!map.containsKey(len)) {
  //                    HashMap<String, Integer> tm = new HashMap<String, Integer>();
  //                    tm.put(res, 1);
  //                    map.put(len, tm);
  //                } else {
  //                    HashMap<String, Integer> tm = map.get(len);
  //                    if (!tm.containsKey(res)) {
  //                        tm.put(res, 1);
  //                    } else {
  //                        tm.put(res, tm.get(res) + 1);
  //                    }
  //                }
  //            }
  //        }
  //
  //        int m = in.nextInt();
  //        while (m-- > 0) {
  //            int k = in.nextInt();
  //            int[] qn = new int[k];
  //            for (int i = 0; i < k; i++) {
  //                qn[i] = in.nextInt();
  //            }
  //            if (k > n) {
  //                out.writeln(0);
  //            } else {
  //                String qs = intToS(qn);
  //                HashMap<String, Integer> tm = map.get(k);
  //                if (tm.containsKey(qs)) {
  //                    out.writeln(tm.get(qs));
  //                } else {
  //                    out.writeln(0);
  //                }
  //            }
  //        }
  //    }
}
