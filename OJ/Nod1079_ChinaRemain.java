package algsPractice.OJ;

import java.util.Scanner;

/**
 * Created by Scruel on 2017/3/31.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #math
 */
public class Nod1079_ChinaRemain {
        //获取最小公倍数
        static int[][] num = new int[10][2];
        static int n;


        static void solve5() {
                //TODO 中国剩余定理，根据公式还未解决，有兴趣的可以尝试下
                long productSum = 1;
                long[] reciprocals = new long[n];
                long coefficient = 0;
                for (int i = 0; i < n; i++) {
                        productSum *= num[i][1];
                }
                for (int i = 0; i < n; i++) {
                        long prodcut = productSum / num[i][1];
                        reciprocals[i] = prodcut % num[i][1];
//                        coefficient += reciprocals[i] * prodcut * num[i][0];
                        coefficient += reciprocals[i] * prodcut * num[i][0];
                }
                long res = coefficient;
                int k = 0;
                while (res > 0) {
                        res -= ++k * productSum;
                }
                System.out.println(res + productSum);
        }

        static void solve4() {
                long productSum = 1;
                for (int i = 0; i < n; i++) {
                        productSum *= num[i][0];
                }

                long inverseE;
                long rsltBase = 0;
                long excludeProduct;

                for (int i = 0; i < n; i++) {
                        excludeProduct = productSum / num[i][0];
                        inverseE = quickPower(excludeProduct, num[i][0] - 2, num[i][0]); // 费马小定理
                        rsltBase += num[i][1] * inverseE * excludeProduct;
                }

                while (rsltBase > 0)
                        rsltBase -= productSum;
                rsltBase += productSum;
                System.out.println(rsltBase);
        }

        public static long quickPower(long a, long b, long c) {
                long rslt = 1;

                do {
                        if ((b & 1) == 1)
                                rslt *= a;

                        if (rslt >= c)
                                rslt %= c;

                        a *= a;
                        if (a >= c)
                                a %= c;

                        b >>>= 1;
                }
                while (b != 0);

                return rslt;
        }

        static void solve3() {
                long productSum = 1;
                for (int i = 0; i < n; i++) {
                        productSum *= num[i][0];
                }
                long sum = 0;
                for (int i = 0; i < n; i++) {
                        long m1 = productSum / num[i][0];
                        long j = 1;
                        while (true) {
                                if (m1 * j % num[i][0] == 1)
                                        break;
                                j++;
                        }
                        sum += (m1 * j * num[i][1]) % productSum;
                }
                System.out.println(sum % productSum);
        }

        static void exch(int i, int j) {
                int temp0 = num[i][0];
                int temp1 = num[i][1];
                num[i][0] = num[j][0];
                num[i][1] = num[j][1];
                num[j][0] = temp0;
                num[j][1] = temp1;

        }

        //无脑暴力优化
        //预先传入较大的一个step，但测试后发现这对优化解的意义不大
        static void solve2(int start, int step) {
                boolean[] isR = new boolean[10];
                //这里
                isR[0] = true;
                //K小于等于10^9，int
                for (int k = start; ; k += step) {
                        boolean flag = true;
                        for (int j = 0; j < n; j++) {
                                //当前的步长已经确保为最优
                                if (!isR[j]) {
                                        if (k % num[j][0] != num[j][1]) {
                                                flag = false;
                                                break;
                                        } else {
                                                isR[j] = true;
                                                //质数乘法，一定会是最小公倍数，也可以用lcm，即最小公倍数
                                                step *= num[j][0];
//                                        int temp = lcm(step, num[j][0]);
                                        }
                                }
                        }
                        if (flag) {
                                System.out.println(k);
                                break;
                        }
                }
        }

        static boolean ok(int i) {
                for (int j = 0; j < n; j++) {
                        if (i % num[j][0] != num[j][1])
                                return false;
                }
                return true;
        }

        static void solve(int start, int step) {
                for (int i = start; ; i += step) {
                        if (ok(i)) {
                                System.out.println(i);
                                break;
                        }
                }
        }

        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                n = input.nextInt();
                for (int i = 0; i < n; i++) {
                        num[i][0] = input.nextInt();
                        num[i][1] = input.nextInt();
                }
                //暴力解法
                solve(num[0][1], num[0][0]);
                solve2(num[0][1], num[0][0]);
                //定理应用
                solve3();
                solve4();
        }
}
