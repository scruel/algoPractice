package algsPractice.competition.codem.p;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Scruel.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 */
public class TaskD {
  static double EPS = 1e-10;
  static long[] nums;
  static OutputWriter out;
  static long[][] table;
  static int dis = 1000000;
  static int[] prime = new int[3438];
  static boolean[] isPrime = new boolean[40007];
  static int[] p = new int[3438];
  static int[] cnt = new int[3438];
  static int[] divisor = new int[1500];

  public static void main(String[] args) throws IOException {
    getPrime(32000);
    nums = new long[10];
    BufferedOutputStream bfs = new BufferedOutputStream(new FileOutputStream("K:\\Program\\Programing\\javaDev\\myProjects\\Algorithm\\src\\data.txt"));
    int j = 0;
    long[][] tb = new long[1000 + 5][];
    //生成分段表
    for (int i = 1; i <= 1000000000; i++) {
      long[] tnums = getNums(i);
      for (int k = 1; k <= 9; k++) {
        nums[k] += tnums[k];
        tnums[k] = nums[k];
      }
      if ((i % dis) == 0) {
        tb[j++] = tnums;
      }
    }

    bfs.write(("{").getBytes());
    for (int i = 0; i < j; i++) {
      bfs.write(("{").getBytes());
      for (int k = 1; k <= 9; k++) {
        bfs.write((tb[i][k] + "").getBytes());
        if (k != 9) {
          bfs.write((",").getBytes());
        }
      }
      bfs.write(("}").getBytes());
      if (i != j - 1) {
        bfs.write((",").getBytes());
      }
    }
    bfs.write(("}").getBytes());
    bfs.close();
  }

  static void print() {
    for (int i = 1; i <= 9; i++) {
      //            nums[i];
      out.writeln(nums[i]);
    }
  }

  static void getPrime(int x) {
    for (int i = 1; i < x; i += 2) {
      isPrime[i] = true;
      isPrime[i - 1] = false;
    }
    prime[prime[0] = 1] = 2;
    for (int i = 3; ; i += 2)
      if (isPrime[i]) {
        int j = i * i, k = i + i;
        if (j >= x) {
          break;
        }
        while (j < x) {
          isPrime[j] = false;
          j += k;
        }
      }
    for (int i = 3; i < x; i += 2)
      if (isPrime[i]) {
        prime[++prime[0]] = i;
      }
  }

  static void getPrimeDivisor(int x) {
    p[0] = cnt[0] = 0;
    int t;
    for (int i = 1; prime[i] * prime[i] <= x && i <= prime[0]; ++i) {
      t = 0;
      while (x % prime[i] == 0) {
        ++t;
        x /= prime[i];
      }
      if (t != 0) {
        p[++p[0]] = prime[i];
        cnt[++cnt[0]] = t;
      }

    }
    if (x > 1) {
      p[++p[0]] = x;
      cnt[++cnt[0]] = 1;
    }

  }

  static void getDivisor(int x) {
    getPrimeDivisor(x);
    divisor[0] = 1;
    divisor[1] = 1;
    for (int i = 1; i <= p[0]; ++i) {
      int nowNum = divisor[0];
      int base = 1;
      for (int j = 1; j <= cnt[i]; ++j) {
        base *= p[i];
        for (int k = 1; k <= divisor[0]; ++k)
          divisor[++nowNum] = divisor[k] * base;
      }
      divisor[0] = nowNum;
    }
  }


  static long[] getNums(int num) {
    long[] tnums = new long[10];
    getDivisor(num);
    for (int i = 1; i <= divisor[0]; ++i) {
      int tt = divisor[i];
      while (tt >= 10)
        tt /= 10;
      tnums[tt]++;
      //            ans += get(divisor[i], m);
    }


    //        HashSet<Integer> tst = new HashSet<Integer>();
    //        int m = (int) (Math.sqrt(num) + 0.5);
    //        for (int j = 1; j <= m; j++) {
    //            double t = num / (double) j;
    //            if (Math.abs(Math.floor(t) - t) < EPS) {
    //                int tt = (int) t;
    //                if (!tst.contains(tt)) {
    //                    while (tt >= 10) tt /= 10;
    //                    tnums[tt]++;
    //                    tst.add(tt);
    //                }
    //                int tt2 = j;
    //                if (!tst.contains(tt2)) {
    //                    while (tt2 >= 10) tt2 /= 10;
    //                    tnums[tt2]++;
    //                    tst.add(tt2);
    //                }
    //            }
    //        }
    return tnums;
  }


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.out = out;
    getPrime(32000);
    nums = new long[10];
    int l = in.nextInt();
    int r = in.nextInt();
    for (int i = l; i <= r; i++) {
      long[] tnums = getNums(i);
      for (int j = 1; j <= 9; j++) {
        nums[j] += tnums[j];
      }
    }
    print();
  }
}
