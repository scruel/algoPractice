package algsPractice.oj;

/**
 * Created by Scruel on 2017/4/8.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 蓝桥杯2017省赛，BQ2  210
 * #prime
 */
public class LQSS2017_BQ2 {
  public static void main(String[] args) {
    int n = 10000000;
    int num_prime = 0;
    boolean[] isNotPrime = new boolean[n];
    isNotPrime[0] = true;
    isNotPrime[1] = true;
    int[] prime = new int[n];
    for (int i = 2; i < n; i++) {
      //筛去不是素数的
      if (!isNotPrime[i]) {
        prime[num_prime++] = i;
      }
      if (!isNotPrime[i]) {
        for (int j = i; j < n; j += i) {
          isNotPrime[j] = true;
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < num_prime; i++) {
      //                        System.out.println(prime[i]);
      for (int j = 1; j <= 1000; j++) {
        int pr = prime[i];
        int len = 0;
        int limit = 10;
        while (isPrime(pr)) {
          pr += j;
          len++;
          if (len >= limit) {
            break;
          }
        }
        pr = prime[i];
        if (len == limit) {
          len = 0;
          System.out.print(j + ":");
          while (len < limit) {
            System.out.print(pr + " ");
            pr += j;
            len++;
          }
          System.out.println();
        }
      }
    }

  }


  public static boolean isPrime(long n) {
    if (n <= 1) {
      return false;
    }
    if (n == 2) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    int m = (int) (Math.sqrt(n) + 0.5);
    for (int i = 3; i < m; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
