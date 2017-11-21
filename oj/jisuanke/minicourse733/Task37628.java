package algsPractice.oj.jisuanke.minicourse733;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.util.Arrays;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class Task37628 {
  static final double EPS = 1e-10;
  static final int INF = 0x3f3f3f3f;
  static final long INFL = 0x3f3f3f3f3f3f3f3fL;
  static final int MOD = 1000000007;

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int[] nums = new int[5];
    int[] ds = new int[5];
    for (int i = 0; i < 5; i++) {
      nums[i] = in.nextInt();
      ds[i] = nums[i] > 10 ? 10 : nums[i];
    }
    //f b
    Arrays.sort(nums);
    int cnt = 1;
    int pre = nums[0];
    boolean flag = false;
    for (int i = 1; i < 5; i++) {
      if (pre != nums[i]) {
        pre = nums[i];
        cnt = 1;
      }
      else {
        cnt++;
      }

      if (cnt == 4) {
        flag = true;
        break;
      }
    }
    if (flag) {
      out.writeln("quadra bomb orz");
      return;
    }


    flag = true;
    cnt = 0;
    for (int i = 0; i < 5; i++) {
      if (nums[i] >= 5) {
        flag = false;
        break;
      }
      cnt += ds[i];
    }
    if (cnt > 10) {
      flag = false;
    }
    if (flag) {
      out.writeln("penta calf");
      return;
    }


    for (int i = 0; i < 5; i++) {
      for (int j = i + 1; j < 5; j++) {
        for (int k = j + 1; k < 5; k++) {
          if ((ds[i] + ds[j] + ds[k]) % 10 == 0) {
            cnt = 0;
            for (int m = 0; m < 5; m++) {
              if (m != i && m != j && m != k) {
                cnt += ds[m];
              }
            }
            if (cnt % 10 == 0) {
              out.writeln("you can you up");
            }
            else {
              out.writeln("too young too simple:calf " + (cnt % 10));
            }
            return;
          }
        }
      }
    }

    out.writeln("gg");
  }
}
