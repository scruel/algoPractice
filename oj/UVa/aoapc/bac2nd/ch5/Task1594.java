package algsPractice.oj.UVa.aoapc.bac2nd.ch5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

/**
 * Created by Scruel on 2017/4/26.  
 * Github : https://github.com/scruel
 * #easy #structure
 */
public class Task1594 {

  public static void main(String[] args) throws IOException {
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(bfr.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(bfr.readLine());
      HashSet<Pair> set = new HashSet<Pair>();
      int[] nums = new int[n];
      int[] nextNums = new int[n];
      String[] rts = bfr.readLine().split("\\s+");
      for (int i = 0; i < n; i++) {
        nums[i] = Integer.parseInt(rts[i]);
      }
      int zeroSum;
      //                        int loopSum = 0;
      while (true) {
        //                                if (loopSum++ > 1000)
        //                                        break;
        for (int i = 0; i < n - 1; i++)
          nextNums[i] = Math.abs(nums[i] - nums[i + 1]);
        nextNums[n - 1] = Math.abs(nums[n - 1] - nums[0]);
        for (int i = 0; i < n; i++)
          nums[i] = nextNums[i];
        Pair tmp = new Pair(nums);
        if (set.contains(tmp)) {
          break;
        }
        set.add(tmp);
        //                                for (int i = 0; i < n; i++) {
        //                                        if (nextNums[i] != arr[i]) {
        //                                                flag = false;
        //                                                break;
        //                                        }
        //                                        if (nextNums[i] == 0)
        //                                                zeroSum++;
        //                                }
      }
      boolean flag = true;
      for (int i = 0; i < n; i++) {
        if (nextNums[i] != 0) {
          flag = false;
          break;
        }
      }
      if (flag) {
        bfw.write("ZERO\n");
      }
      else {
        bfw.write("LOOP\n");
      }
    }
    bfr.close();
    bfw.close();
  }

  static class Pair {
    int[] pair;

    public Pair(int[] p) {
      pair = new int[p.length];
      for (int i = 0; i < pair.length; i++)
        pair[i] = p[i];

    }

    @Override
    public boolean equals(Object obj) {
      Pair p = (Pair) obj;
      for (int i = 0; i < pair.length; i++) {
        if (pair[i] != p.pair[i]) {
          return false;
        }
      }
      return true;
    }

    @Override
    public int hashCode() {
      int prime = 31;
      int result = 1;
      for (int i = 0; i < pair.length; i++) {
        result = result * prime + pair[i];
      }
      return result;
    }
  }

}
