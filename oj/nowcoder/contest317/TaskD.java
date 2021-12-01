package algsPractice.oj.nowcoder.contest317;

import algsPractice.lib.InputReader;
import algsPractice.lib.OutputWriter;

/**
 * @author Scruel Tao
 */
public class TaskD {
  private static final int MOD = (int) 1e9 + 7;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long k = in.nextLong();
    long A = in.nextLong();
    long B = in.nextLong();

    long l = (n * euler_phi(n) / 2) % MOD;
    long p = euler_phi(MOD);
    long b = l % p + p;
    long kr = q_mod(k, b);
    long res = ((A % MOD) * kr) % MOD;
    res += ((B % MOD) * kr) % MOD;
    out.println(res % MOD);
  }

  private long q_mod(long a, long b) {
    long res = 1;
    while (b != 0) {
      if (b % 2 != 0)
        res = res * a % MOD;
      a = a * a % MOD;
      b /= 2;
    }
    return res;
  }

  long euler_phi(long n) //欧拉函数模板
  {
    long res = n, i;
    for (i = 2; i * i <= n; i++) {
      if (n % i == 0)
        res = res / i * (i - 1);//先进行除法是为了防止中间数据的溢出
      while (n % i == 0)
        n /= i;
    }
    if (n > 1)
      res = res / n * (n - 1);//保证x一定是素数
    return res;
  }
}
