package algsPractice.OJ;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/4/14.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #prime
 */
public class CF17A {
    static boolean[] isNotPrime;
    static boolean[] mark;
    static int[] prime;
    static int primeIndex;
    static int n;
    static int k;

    static void solve() {
        isNotPrime = new boolean[n + 1];
        prime = new int[n + 1];
        mark = new boolean[n + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;


        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                prime[primeIndex++] = i;
                if (mark[i]) k--;
                if (primeIndex > 1 && prime[primeIndex - 1] + prime[primeIndex - 2] + 1 <= n) {
                    int tmp = prime[primeIndex - 1] + prime[primeIndex - 2] + 1;
                    mark[tmp] = true;
                }
                for (int j = i * i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        if (k > 0)
            System.out.println("NO");
        else
            System.out.println("YES");

    }

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        k = input.nextInt();
//                solve();
        prime = new int[n + 1];
        prime[primeIndex++] = 2;

        for (int i = 3; i <= n; i++) {
            if (isPrime(i)) {
                prime[primeIndex++] = i;
                if (prime[primeIndex - 1] + prime[primeIndex - 2] + 1 <= n && isPrime(prime[primeIndex - 1] + prime[primeIndex - 2] + 1))
                    k--;
            }
        }
        if (k > 0)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
