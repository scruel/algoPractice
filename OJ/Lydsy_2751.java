package algsPractice.OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Scruel on 2017/4/10.
 * Personal blog : http://blog.csdn.net/scruelt
 * Github : https://github.com/scruel
 * #快速幂
 * #unsolved
 */
public class Lydsy_2751 {
        static final int MOD = 1000000007;
        static BufferedReader bfr;
        static StringTokenizer st;
        static int N, M, K;
        static int left;
        static Pair[] pairs;

        static int next() throws IOException {
                while (left == 0) {
                        String s = bfr.readLine();
                        st = new StringTokenizer(s);
                        left = st.countTokens();
                }
                left--;
                return Integer.parseInt(st.nextToken());
        }

        public static void main(String[] args) throws IOException {

//                Scanner input = new Scanner(new FileInputStream("K:\\Program\\Programing\\javaDev\\myProjects\\javaWorkSpace\\algorithm\\src\\algs4_new\\data.txt"));
//                N = input.nextInt();
//                M = input.nextInt();
//                K = input.nextInt();
//                bfr = new BufferedReader(new InputStreamReader(new FileInputStream("K:\\Program\\Programing\\CDev\\data.txt")));
                bfr = new BufferedReader(new InputStreamReader(System.in));
                N = next();
                M = next();
                K = next();
                pairs = new Pair[K + 1];

                int T = M;
                pairs[0] = new Pair(0, 0);
                for (int i = 1; i <= K; i++) {
                        int a = next();
                        int b = next();
//                        int a = input.nextInt();
//                        int b = input.nextInt();
                        pairs[i] = new Pair(a, b);
                }
                Arrays.sort(pairs);
                long ans = 1;
                //使用等差数列求和公式计算1+..+N的值
                long ss = ((long) N * (N + 1) / 2) % MOD;
                long temp = ss;
                //暴力解限制对应的情况
                for (int i = 1; i <= K; i++) {
                        //index值变化，说明已经完成了其中一个位置的计算
                        if (i != 1 && pairs[i].index != pairs[i - 1].index) {
                                ans = (ans * temp) % MOD;
                                temp = ss;
//                                System.out.println(ans);
                                T--;
                        }
                        //检查是否是同编号的重复值，如果不是则计算
                        if (pairs[i].num != pairs[i - 1].num || pairs[i].index != pairs[i - 1].index) {
                                temp = (temp - pairs[i].num + MOD) % MOD;
                        }
                }
                T--;
                ans = (ans * temp) % MOD;
//                System.out.println(ans);
//                System.out.println(getConstantPower(ss, T));
                ans = (ans * getConstantPower(ss, T)) % MOD;
                System.out.println(ans);
                bfr.close();
        }

        static long getConstantPower(long k, long N) {
                if (N == 0) return 1;
                if (N == 1) return k;
                long temp = getConstantPower(k, N >> 1);
                temp = (temp * temp) % MOD;
                if ((N & 1) != 0)
                        temp = (temp * k) % MOD;
                return temp;
        }

//        static long getConstantPower(long a, long b) {
//                long ans = 1;
//                for (long i = b; i == 0; i >>= 1, a = (a * a) & MOD) {
//
//                        if ((i & 1) != 0) {
//                                ans = (ans * a) % MOD;
//                        }
//                }
//                return ans;
//        }

        static class Pair implements Comparable<Pair> {
                int index;
                int num;

                public Pair(int index, int num) {
                        this.index = index;
                        this.num = num;
                }

                public int compareTo(Pair p) {
                        if (this.index < p.index) return -1;
                        if (this.index > p.index) return 1;
                        return 0;
                }
        }
}
