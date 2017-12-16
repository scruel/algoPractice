package algsPractice.dpExercise;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/13.  
 * Github : https://github.com/scruel
 * <p>
 * 赌圣atm晚年迷恋上了垒骰子，就是把骰子一个垒在另一个上边，不能歪歪扭扭，要垒成方柱体。 经过长期观察，atm
 * 发现了稳定骰子的奥秘：有些数字的面贴着会互相排斥！ 我们先来规范一下骰子：1 的对面是 4，2 的对面是 5，3 的对面是 6。 假设有 m
 * 组互斥现象，每组中的那两个数字的面紧贴在一起，骰子就不能稳定的垒起来。 atm想计算一下有多少种不同的可能的垒骰子方式。
 * 两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同。 由于方案数可能过多，请输出模 10^9 + 7 的结果。
 * <p>
 * 不要小看了 atm 的骰子数量哦～
 * <p>
 * 「输入格式」 第一行两个整数 n m n表示骰子数目 接下来 m 行，每行两个整数 a b ，表示 a 和 b 不能紧贴在一起。
 * <p>
 * 「输出格式」 一行一个数，表示答案模 10^9 + 7 的结果。
 * <p>
 * 「样例输入」 2 1 1 2
 * <p>
 * 「样例输出」 544
 * <p>
 * 「数据范围」 对于 30% 的数据：n <= 5 对于 60% 的数据：n <= 100 对于 100% 的数据：0 < n <=
 * 10^9, m <= 36
 * <p>
 * 资源约定： 峰值内存消耗（含虚拟机） < 256M CPU消耗 < 2000ms
 * **递归** **矩阵快速幂**
 */
public class LeiDice {
  public static final long MOD = 1000000007;
  // turn[i]=j代表 点数为i的面 的对立面点数为j
  static int turn[] = {0, 4, 5, 6, 1, 2, 3};
  // 冲突记录: Conflict[i][j]=0代表点数为i的面与点数为j的面存在冲突
  static long conflict[][] = new long[7][7];

  // 获得一个单位矩阵
  static long[][] getIdentity(long[][] a) {
    for (int i = 1; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        a[i][j] = 1;
      }
    }
    return a;
  }


  // 矩阵乘法
  static long[][] Multiply_Matrix(long[][] a, long[][] b) {
    long[][] c = new long[a.length][b[0].length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        long temp = 0;
        for (int k = 0; k < b.length; k++) {
          temp = (temp + ((a[i][k] % MOD) * (b[k][j] % MOD)) % MOD) % MOD;
        }
        c[i][j] = temp;
      }
    }
    return c;
  }

  // 常数快速幂
  static long exp_mod(long a, long n) {
    long t;
    if (n == 0) {
      return 1 % MOD;
    }
    if (n == 1) {
      return a % MOD;
    }
    t = exp_mod(a, n / 2);// 注意这里n/2会带来奇偶性问题
    t = t * t % MOD;// 乘上另一半再求模
    if ((n & 1) == 1) {
      t = t * a % MOD;// n是奇数，因为n/2还少乘了一次a
    }
    return t;
  }

  // 矩阵快速幂
  static long[][] Multiply_ksm(long[][] a, long k) {
    long[][] d = new long[a.length][a[0].length];
    if (k == 1) {
      return a;
    }
    else if (k == 2) {
      return Multiply_Matrix(a, a);
    }
    else if (k % 2 == 0) {
      d = Multiply_ksm(Multiply_Matrix(a, a), k / 2);
      return d;
    }
    else {
      d = Multiply_ksm(Multiply_Matrix(a, a), k / 2);
      return Multiply_Matrix(d, a);
    }
  }


  public static void main(String[] args) {


    getIdentity(conflict);
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    int m = sc.nextInt();
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      conflict[turn[a]][b] = conflict[turn[b]][a] = 0;
      // 如果1和2存在冲突, 那么Compact[4][2] 和 Compact[5][1] 都为0 , 因为4的反面是1,5的反面是2.
    }
    // 单列矩阵dp[j][1]来记录高度为N时, 顶面为j的总方案数.
    long dp[][] = new long[7][1];
    getIdentity(dp);
    // 矩阵dp记录了当前某高度下的各个面的总方案数, 而矩阵Conflict的行向量则作为"选择"的依据.
    // Conflict * dp = newdp;
    // 如果 dp 记录了高度为N的各个面的总方案数;
    // 那么 newdp 记录了高度为N+1的各个面的总方案数;
    dp = Multiply_Matrix(Multiply_ksm(conflict, n - 1), dp);
    long sum = 0;
    for (int i = 0; i < dp.length; i++) {
      sum = (sum + dp[i][0]) % MOD;// 将dp里面的所有方案数累加, 即得到总方案数.
    }
    sum = (sum * exp_mod(4, n)) % MOD;// 采用常数快速幂的形式,乘上每个骰子可以四面转向的情况.
    System.out.println(sum);
    sc.close();
  }


}

