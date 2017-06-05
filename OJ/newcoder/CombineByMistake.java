package algsPractice.OJ.newcoder;

/**
 * Created by Scruel on 2017/3/22.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * 错装信封问题
 */
public class CombineByMistake {
    static int MOD = 1000000007;

    static int countWays(int n) {
        // write code here
        if (n < 2) return 0;
        if (n == 2) return 1;
        return (n - 1) * (countWays(n - 1) % MOD + countWays(n - 2) % MOD);
    }

    static int countWaysNoRecursion(int n) {
        // write code here
        int a = 0;
        int b = 1;
        if (n <= 1) return a;
        if (n == 2) return b;
        long result = 0;
        long x = 0;
        long y = 1;
        for (int i = 3; i <= n; i++) {
            result = (i - 1) * (x + y) % MOD;
            x = y;
            y = result;
        }
        return (int) result;
    }

    static int countWaysDP(int n) {

        long[] dp = new long[n + 1];
        //这里如果是int数组，就会溢出，因为下面即便对加号位置取余了，乘法得到的结果会导致整数溢出。
        dp[0] = 0;
        if (n >= 1) dp[1] = 0;
        if (n >= 2) dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2]) % MOD) % MOD;
            if (dp[i] < 0) System.out.println(i);
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        int n = 143;
        System.out.println(countWaysDP(n));
        System.out.println(countWaysNoRecursion(n));
        System.out.println(countWays(n));
    }
}
